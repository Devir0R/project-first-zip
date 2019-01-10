from selenium import webdriver
#import time
#from selenium.common.exceptions import UnexpectedAlertPresentException
#from selenium.common.exceptions import NoAlertPresentException



def test(uri,expected):
    main = uri

    driverPath = 'C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe'
    webdriver.ChromeOptions().add_argument('--headless')
    driver = webdriver.Chrome(executable_path=driverPath)
    driver.get(main)

    ans = driver.find_elements_by_tag_name('pre')[0].get_attribute('innerHTML') + ''
    driver.close()
    return (ans == expected,ans)

uri_s = [
    'http://localhost:53121/api/Players',
    'http://localhost:53121/api/Players/1',
    'http://localhost:53121/api/Players/2'
]
expected_s = [
    '[{"player_Id":1,"name":"Kylian","last_name":"Mbappe","club":"PSG","nationality":"France","position":"striker","in_game":false,"CompetitionStatistics":[],"Users":[]},{"player_Id":2,"name":"Muhammad","last_name":"Salah","club":"Liverpool","nationality":"Egypt","position":"right_winger","in_game":false,"CompetitionStatistics":[],"Users":[]}]',
    '{"player_Id":1,"name":"Kylian","last_name":"Mbappe","club":"PSG","nationality":"France","position":"striker","in_game":false,"CompetitionStatistics":[],"Users":[]}',
    '{"player_Id":2,"name":"Muhammad","last_name":"Salah","club":"Liverpool","nationality":"Egypt","position":"right_winger","in_game":false,"CompetitionStatistics":[],"Users":[]}'
]
def test_all():
    count = 0;
    for i in range(0,len(uri_s)):
        passed,out = test(uri_s[i],expected_s[i])
        if(passed):
            print('test {0} succeeded!'.format(i+1))
            count += 1
        else:
            print('test {0} failed,\nexpected: {1}\noutput: {2}'.format(i+1,expected_s[i],out))

    print("total: {0} passed out of {1}".format(count,len(uri_s)))

test_all()
