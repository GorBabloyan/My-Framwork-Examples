import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Porc {
    public static int runTest(String regex, String text, int flag) {
        Pattern pattern = Pattern.compile(regex, flag);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }
    @Test
    void v () {
        Pattern p = Pattern.compile("^(077|099)+(\\d{6})$");
        Matcher m = p.matcher("099123456");
        Assert.assertTrue(m.find());
        System.out.println(m.find());
    }

    public static void main(String[] args) throws InterruptedException {

//        System.out.println("Matches are: " + runTest("hey","heyeyeyhey"));
//        System.out.println("Matches are: " + runTest("ey","heyeyeyhey"));
//        System.out.println("Matches are: " + runTest("a","heyeyeyhey"));
//        System.out.println("Matches are: " + runTest("ey.","heykeykeyheyk"));
//        System.out.println("Matches are: " + runTest("[kabch]","heyeyeyheyak"));
//        System.out.println("Matches are: " + runTest("[yeh]","hey"));
//        System.out.println("Matches are: " + runTest("[yeh]am","heyam"));
//        System.out.println("Matches are: " + runTest("[^yeh]","heyk"));
//        System.out.println("Matches are: " + runTest("[^yeh]ka","abcka"));
//        System.out.println("Matches are: " + runTest("[A-Za-z]","Hello Word 2024"));
//        System.out.println("Matches are: " + runTest("[a-z]","Hello Word 2024"));
//        System.out.println("Matches are: " + runTest("[A-Z]","Hello Word 2024"));
//        System.out.println("Matches are: " + runTest("[0-3]","Hello Word 2024"));
//        System.out.println("Matches are: " + runTest("[11-25]","Hello Word 2024"));
//        System.out.println("Matches are: " + runTest("[0-3[7-9]]","1234567890"));
//        System.out.println("Matches are: " + runTest("[0-3&&[2-4]]","1234567890"));
//        System.out.println("Matches are: " + runTest("[0-9&&[^0-7]]","1234567890"));
//        System.out.println("Matches are: " + runTest("\\d","123abc")); //matches number [0-9]
//        System.out.println("Matches are: " + runTest("\\D","123a")); //not matches number [^0-9]
//        System.out.println("Matches are: " + runTest("\\s","1 2 3abc&8*")); //matches White space
//        System.out.println("Matches are: " + runTest("\\s","1 2 3")); //matches noy White space
//        System.out.println("Matches are: " + runTest("\\w","hey!!!")); //matches [A-Za-z_0-9]
//        System.out.println("Matches are: " + runTest("\\W","hey!!")); //matches non word characters[^A-Za-z_0-9]
//        System.out.println("Matches are: " + runTest("\\a?","hey!!!")); //String.length + 1 from java
//        System.out.println("Matches are: " + runTest("\\a{0,6}","hey!!!")); //String.length{0-6} + 1 from java
//        System.out.println("Matches are: " + runTest("(//d//d)","121212")); //first two need to be nums
//        System.out.println("Matches are: " + runTest("^12a","12a12 712a7ggg!12")); //first is 12a
//        System.out.println("Matches are: " + runTest("dog$","12121 dog 2dog")); //last word is dog
//        System.out.println("Matches are: " + runTest("\\bdog\\b","dog sys dog hy")); //dog  with not word[A-Za-z_0-9]  boundreas
//        System.out.println("Matches are: " + runTest("dog","Dog is animal", Pattern.CASE_INSENSITIVE)); //its ignore Case mismatching
//        System.out.println("Matches are: " + runTest("$dog #find word dog in a test","dog hey", Pattern.COMMENTS)); //#understending that after # starts comment
//
//        String regex1 = "^(077|099)+(\\d{6})$" ;
//        String text = "099123456";
//        if (runTest(regex1,text)>0){
//            System.out.println(text + " is valid num");
//        }
//        else {
//            System.out.println(text + " ENTER VALID NUMBER");
//        }




//        WebDriverManager.safaridriver().setup();
//        WebDriver driver = new SafariDriver();
//        driver.get("http://automationpractice.com/index.php");
//        Thread.sleep(1000);
//        String el = driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a")).getAttribute("title");
//        System.out.println("element is:" + el);
//        driver.quit();
    }
}
