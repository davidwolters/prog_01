import os

def get_file_contents(file_name):
    try: 
        file = open(file_name)
        contents = file.read()
        file.close()
        return contents
    except Exception as ex:
        print(ex)
        return "" 

def lowercase(string: str):
    return string.lower()

def test_lowercase():
    print(lowercase("aSdfF"))

def get_words(string: str):
    return string.split(" ")

def get_alpha(string: str):
    return ''.join(filter(lambda s: str.isalpha or s == ' ', string))

def get_num_words(list):
    return len(list)



def test_get_file_contents():
    print(get_file_contents(os.path.realpath(os.path.dirname(__file__)) + "/test1.txt"))

if __name__ == '__main__':
    test_get_file_contents()
    test_lowercase()