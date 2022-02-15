import unittest
from library.patron import Patron
from unittest.mock import Mock

class TestPatron(unittest.TestCase):
    def setUp(self):
        self.patron = Patron("fname", "lname", 1, 1234)

    def test_add_borrowed_book(self):
        self.patron.add_borrowed_book("Abc")
        self.assertEqual(self.patron.get_borrowed_books(), ["abc"])
    
    def test_add_borrowed_book_exists(self):
        self.patron.add_borrowed_book("abc")
        self.patron.add_borrowed_book("Abc")
        self.assertEqual(self.patron.get_borrowed_books(), ["abc"])

    def test_return_borrowed_book(self):
        self.patron.add_borrowed_book("abc")
        self.patron.add_borrowed_book("xyz")
        self.patron.return_borrowed_book("abc")
        self.assertEqual(self.patron.get_borrowed_books(), ["xyz"])

    def test_return_borrowed_book_nonexistent(self):
        self.patron.add_borrowed_book("xyz")
        self.patron.return_borrowed_book("abc")
        self.assertEqual(self.patron.get_borrowed_books(), ["xyz"])

    def test_get_fname(self):
        self.assertEqual(self.patron.get_fname(), "fname")

    def test_get_lname(self):
        self.assertEqual(self.patron.get_lname(), "lname")

    def test_get_age(self):
        self.assertEqual(self.patron.get_age(), 1)

    def test_get_memberID(self):
        self.assertEqual(self.patron.get_memberID(), 1234)

    def test___eq__(self):
        p = Patron("fname", "lname", 1, 1234)
        self.assertTrue(self.patron.__eq__(p))

    def test___ne__(self):
        p = Patron("fname", "lname", 1, 12345)
        self.assertTrue(self.patron.__ne__(p))
