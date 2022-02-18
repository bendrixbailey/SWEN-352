import unittest
from library import library_db_interface
from unittest.mock import Mock
import requests
import json

class TestLibraryDBInterface(unittest.TestCase):
    def setUp(self):
        self.db_interface = library_db_interface.Library_DB()

    def test_insert_patron_not_in_db(self):
        mock_patron = Mock()
        self.db_interface.retrieve_patron = Mock(return_value=None)
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 'memberID',
                'borrowed_books': []}
        self.db_interface.convert_patron_to_db_format = Mock(return_value=data)
        self.db_interface.db.insert = Mock(return_value=5)
        self.assertEqual(self.db_interface.insert_patron(mock_patron), 5)

    
    def test_insert_patron_in_db(self):
        mock_patron = Mock()
        self.db_interface.retrieve_patron = Mock(return_value={'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 5,
                'borrowed_books': []})
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 5,
                'borrowed_books': []}
        self.db_interface.convert_patron_to_db_format = Mock(return_value=data)
        self.db_interface.db.insert = Mock(return_value=5)
        self.assertEqual(self.db_interface.insert_patron(mock_patron), None)

    def test_insert_patron_no_patron(self):
        mock_patron = Mock()
        self.assertEqual(self.db_interface.insert_patron("bleh"), None)

    def test_get_patron_empty(self):
        self.assertEqual(self.db_interface.get_patron_count, 0)    

    def test_get_patron_count(self):
        patron_mock = Mock()
        patron_mock.get_fname = Mock(return_value="Joe")
        patron_mock.get_lname = Mock(return_value="Blo")
        patron_mock.get_age = Mock(return_value=30)
        patron_mock.get_memberID = Mock(return_value=2)
        patron_mock.get_borrowed_books = Mock(return_value=5)
        self.db_interface.insert_patron(patron_mock)
        self.assertEqual(self.db_interface.get_patron_count, 1)

    def test_get_all_patrons(self):
        patron_mock = Mock()
        patron_mock.get_fname = Mock(return_value="Joe")
        patron_mock.get_lname = Mock(return_value="Blo")
        patron_mock.get_age = Mock(return_value=30)
        patron_mock.get_memberID = Mock(return_value=2)
        patron_mock.get_borrowed_books = Mock(return_value=5)
        self.db_interface.insert_patron(patron_mock)
        self.assertEqual(self.db_interface.get_all_patrons, [{'fname': "Joe", 'lname': "Blo", 'age': 30, 'memberID': 2,
                          'borrowed_books': 5}])

    def test_update_patron(self):
        data = {'fname': 'name', 'lname': 'name', 'age': 'age', 'memberID': 'memberID',
                'borrowed_books': []}
        self.db_interface.convert_patron_to_db_format = Mock(return_value=data)
        db_update_mock = Mock()
        self.db_interface.db.update = db_update_mock
        self.db_interface.update_patron(Mock())
        db_update_mock.assert_called()

    def test_update_patron_no_patron(self):
        self.assertEqual(self.db_interface.update_patron("bleh"), None)

    def test_retrieve_patron_no_match(self):
        self.db_interface.db.search = Mock(return_value=None)
        self.assertEqual(self.db_interface.retrieve_patron(3), None)

    def test_retrieve_patron_match(self):
        self.db_interface.db.search = Mock(return_value=[{'fname': "Joe", 'lname': "Blo", 'age': 30, 'memberID': 2,
                          'borrowed_books': 5}])
        self.assertEqual(self.db_interface.retrieve_patron(2), {'fname': "Joe", 'lname': "Blo", 'age': 30, 'memberID': 2,
                          'borrowed_books': 5})

    def test_convert_patron_to_db_format(self):
        patron_mock = Mock()
        patron_mock.get_fname = Mock(return_value="Joe")
        patron_mock.get_lname = Mock(return_value="Blo")
        patron_mock.get_age = Mock(return_value=30)
        patron_mock.get_memberID = Mock(return_value=2)
        patron_mock.get_borrowed_books = Mock(return_value=5)
        self.assertEqual(self.db_interface.convert_patron_to_db_format(patron_mock),
                         {'fname': "Joe", 'lname': "Blo", 'age': 30, 'memberID': 2,
                          'borrowed_books': 5})

    def test_close_db(self):
        close = Mock()
        self.db_interface.db.close = close
        self.db_interface.close_db()
        close.assert_called()

