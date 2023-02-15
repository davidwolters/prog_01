from lib import func_result_test
import u1



def test_possible_email():
    func_result_test(
        'possible_email',
        [['test@'], ['asdf'], ['asdf@asdf#'], ['asdf asdf'], ['']],
        [True, True, False, False, True],
        u1.possible_email
    )

def test_is_email():
    func_result_test(
        'is_email',
        [['test@test'], ['test.test@test'], ['test@test.test'], ['test#test.test'], ['a.b@b.a']],
        [False, False, True, False, True],
        u1.is_email
    )

def test_find_all_emails():
    sample_texts = [
        ["asdf a.b@c.d a@ @a a.b.c @d.e a@c.s"],
        ["123@2.se a#b.se b@c.se asdf asdf @c.se"],
        ['']
    ]
    func_result_test(
        'find_all_emails',
        sample_texts,
        [{'a.b@c.d', 'a@c.s'}, {'b@c.se'}, set()],
        u1.find_all_emails
    )

def test_get_url_content():
    func_result_test(
        'get_url_content',
        [['brokenlink'], ['https://www.thiswebsitedoesnotexistnorwilliteverexist.com']],
        [None, None],
        u1.get_url_content,
        expect_error=True
    )
    func_result_test(
        'get_url_content',
        [['https://uu.se']],
        ['Sveriges första universitet'],
        u1.get_url_content,
        validate=lambda res,exp: exp in res 
    )

if __name__ == '__main__':
    test_possible_email()
    test_is_email()
    test_find_all_emails()
    test_get_url_content()
    print("\n==== TESTING print_emails_from_url() ====")
    u1.print_emails_from_url('http://www.it.uu.se/katalog/bylastname')
