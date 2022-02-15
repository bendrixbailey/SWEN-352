import unittest
from library import ext_api_interface
from unittest.mock import Mock
import requests
import json

class TestExtApiInterface(unittest.TestCase):
    def setUp(self):
        self.api = ext_api_interface.Books_API()
        self.book = "learning python"
        with open('tests_data/ebooks.txt', 'r') as f:
            self.books_data = json.loads(f.read())
        with open('tests_data/json_data.txt', 'r') as f:
            self.json_data = json.loads(f.read())


    """make_request tests"""

    def test_make_request_True(self):
        attr = {'json.return_value': dict()}
        requests.get = Mock(return_value = Mock(status_code = 200, **attr))
        self.assertEqual(self.api.make_request(""), dict())

    def test_make_request_connection_error(self):
        ext_api_interface.requests.get = Mock(side_effect=requests.ConnectionError)
        url = "some url"
        self.assertEqual(self.api.make_request(url), None)

    def test_make_request_False(self):
        requests.get = Mock(return_value=Mock(status_code=100))
        self.assertEqual(self.api.make_request(""), None)


    """is_book_available tests"""

    def test_is_book_available_True(self):
        self.api.make_request = Mock(return_value=self.json_data)
        self.assertEqual(self.api.is_book_available(self.book), True)

    def test_is_book_available_False(self):
        self.api.make_request = Mock(return_value=dict())
        self.assertEqual(self.api.is_book_available(self.book), False)


    """books_by_author tests"""
    
    def test_books_by_author(self):
        self.api.make_request = Mock(return_value=self.json_data)
        books = []
        for book in self.json_data['docs']:
            books.append(book['title_suggest'])
        self.assertEqual(self.api.books_by_author(self.book), books)


    """get_book_info tests"""

    def test_get_book_info(self):
        self.api.make_request = Mock(return_value=self.json_data)
        books_info = []
        for book in self.json_data['docs']:
            info = {'title': book['title']}
            if 'publisher' in book:
                info.update({'publisher': book['publisher']})
            if 'publish_year' in book:
                info.update({'publish_year': book['publish_year']})
            if 'language' in book:
                info.update({'language': book['language']})
            books_info.append(info)
        self.assertEqual(self.api.get_book_info(self.book), books_info)

    
    """get_ebooks tests"""

    def test_get_ebooks(self):
        self.api.make_request = Mock(return_value=self.json_data)
        self.assertEqual(self.api.get_ebooks(self.book), self.books_data)

    def test_get_ebooks_None(self):
        self.api.make_request = Mock(return_value=False)
        self.assertEqual(self.api.get_ebooks(self.book), [])
