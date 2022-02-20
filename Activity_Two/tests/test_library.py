import unittest
from unittest.mock import Mock
from library import library
from library import library_db_interface
import json

class TestLibrary(unittest.TestCase):

    def setUp(self):
        self.lib = library.Library()
        self.db_interface = library_db_interface.Library_DB()
        # self.books_data = [{'title': 'Learning Python', 'ebook_count': 3}, {'title': 'Learning Python (Learning)', 'ebook_count': 1}, {'title': 'Learning Python', 'ebook_count': 1}, {'title': 'Learn to Program Using Python', 'ebook_count': 1}, {'title': 'Aprendendo Python', 'ebook_count': 1}, {'title': 'Python Basics', 'ebook_count': 1}]
        with open('tests_data/ebooks.txt', 'r') as f:
            self.books_data = json.loads(f.read())
        with open('tests_data/json_data.txt', 'r') as g:
            self.json_data = json.loads(g.read())

    """is_ebook tests"""
    def test_is_ebook_true(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertTrue(self.lib.is_ebook('learning python'))

    def test_is_ebook_false(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertFalse(self.lib.is_ebook('this should fail'))

    """get_ebooks_count tests"""
    def test_get_ebooks_count(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertEqual(self.lib.get_ebooks_count("learning python"), 8)

    """is_book_by_author tests"""
    def test_is_book_by_author_true(self):
        testing = ["How To Code", "Biography"]
        self.lib.api.books_by_author = Mock(return_value=testing)
        self.assertTrue(self.lib.is_book_by_author("John Smith", "How To Code"))

    def test_is_book_by_author_false(self):
        testing = ["How To Code", "Biography"]
        self.lib.api.books_by_author = Mock(return_value=testing)
        self.assertFalse(self.lib.is_book_by_author("Coolio", "I'm the Best"))

    """get_languages_for_book tests"""
    def test_get_languages_for_book(self):
        bookOne = {"Title":"How To Code", "language":["en"]}
        bookTwo = {"Title":"Ready or Not", "language":["en"]}
        submission = [bookOne, bookTwo]
        setCheck = set()
        setCheck.update(["en"])
        self.lib.api.get_book_info = Mock(return_value=submission)
        self.assertEqual(self.lib.get_languages_for_book("How To Code"), setCheck)

    """register_patron tests"""
    def test_register_patron(self):
        #self.db_interface.insert_patron = Mock(return_value=93781)
        self.assertEqual(self.lib.register_patron("John", "Smith", 25, 13), None)

    """is_patron_registered tests"""
    def test_is_patron_registered_true(self):
        pat = library.Patron("John", "Smith", 30, 13)
        self.lib.db.retrieve_patron = Mock(return_value=pat)
        self.assertTrue(self.lib.is_patron_registered(pat))

    def test_is_patron_registered_false(self):
        pat = library.Patron("John", "Smith", 30, 13)
        self.lib.db.retrieve_patron = Mock(return_value=None)
        self.assertFalse(self.lib.is_patron_registered(pat))

    """borrow_book tests"""
    def test_borrow_book(self):
        pat = library.Patron("John", "Smith", 30, 13)
        self.lib.borrow_book("How To Code", pat)
        self.assertEqual(pat.borrowed_books, ["how to code"])

    """return_borrowed_book test"""
    def test_return_borrow_book(self):
        pat = library.Patron("John", "Smith", 30, 13)
        self.lib.return_borrowed_book("How To Code", pat)
        self.assertEqual(pat.borrowed_books, [])

    """is_book_borrowed test"""
    def test_is_book_borrowed(self):
        pat = library.Patron("John", "Smith", 30, 13)
        self.lib.borrow_book("How To Code", pat)
        self.assertTrue(self.lib.is_book_borrowed("How To Code", pat))