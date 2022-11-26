import java.util.*;
class Alphabet
{
    Scanner scan = new Scanner (System.in);
    static String lower_case = "abcdefghijklmnopqrstuvwxyz";
    static String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String numbers = "0123456789";
    Static String chars = "~!@#$%^&*()_-+=?/\\";
    StringBuilder pool;
    Alphabet(boolean includelower , boolean includeupper , boolean includenumber , boolean includechar)
    {
        pool = new StringBuilder();
        if(includelower)
        {
            pool.append(lower_case);
        }
        if(includeupper)
        {
            pool.append(upper_case);
        }
        if(includenumber)
        {
            pool.append(numbers);
        }
        if(includechar)
        {
            pool.append(chars);
        }
    }
    publis String getAlphabet()
    {
        return pool.toString();
    }
}
class Password
{
    String value;
    int length;
    Password(String s)
    {
        value = s;
        length = s.length();
    }
    int charType(char c)
    {
        char a = C;
        int v = a;
        int val = 0;
        //upper case
        if(v >= 65 && v <= 90)
        {
            val = 1;
        }
        //lower case
        else if(v >= 97 && v <= 122)
        {
            val = 2;
        }
        //numbers
        else if(v >= 48 && v <= 57)
        {
            val = 3;
        }
        //characters
        else
        {
            val = 4
        }
        return val;
    }
    int PasswordStrength()
    {
        String s = this.value;
        boolean UsedUpper=false;
		boolean UsedLower=false;
		boolean UsedNum=false;
		boolean UsedSym=false;
        int type ; 
        int score = 0;
        for(int i - 0 ; i < s.length() ; i++ )
        {
            char c = s.charAt(i);
            type = charType(c);
            //checking char type
             if (type==1) 
            {
		    	UsedUpper=true;
		    }
		    
		    if (type==2) 
            {
		    	UsedLower=true;
		    }
		    
		    if (type==3) 
            {
		    	UsedNum=true;
		    }
		    
		    if (type==4) 
            {
		    	UsedSym=true;
		    }
        }
        //calculating score
        if (UsedUpper==true) 
        {
			Score+=1;
		}
		
		if (UsedLower==true) 
        {
			Score+=1;
		}
		
		if (UsedNum==true) 
        {
			Score+=1;
		}
		
		if (UsedSym==true) 
        {
			Score+=1;
		}
		
		if (s.length()>=8) 
        {
			Score+=1;
		}
		
		if (s.length()>=16) 
        {
			Score+=1;
		}
		return Score;
    }
    int calculateScore()
    {
        int Score=0;
		Score=this.PasswordStrength();
		if (Score==6)
        {
			return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
		}
		else if (Score>=4)
        {
			return "This is a good password :) but you can still do better";
		}
		else if (Score>=3)
        {
			return "This is a medium password :/ try making it better";
		}
		else 
        {
			return "This is a weak password :( definitely find a new one";
		}
    }
   /* @Override
    public String toString() 
    {
		return Value;
	}   */
}
class PasswordGenerator()
{
    boolean IncludeUpper=false;
	boolean IncludeLower=false;
	boolean IncludeNum=false;
	boolean Includechars=false;
    Alphabet alphabet;
    Generator(boolean IncludeUpper,boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) 
    {
		alphabet=new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
	}
    Password GenreatePassword(int length)
    {
        StringBuilder pass = new StringBuilder();
        int alphabetlength = alphabet.getAlphabet().length();
        int max = alphabetLength - 1; 
        int min = 0; 
        int range = max - min + 1; 
        for(int i = 0 ; i < length ; i++)
        {
            int index = (int)(Math.random() * range) + min;
            pass.append(alphabet.getAlphabet.charAt(index));
        }
        return Password(pass.toString());
    }
    static void printUsefulInfo() 
    {
		System.out.println();
		System.out.println("Use a minimum password length of 8 or more characters if permitted");
		System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
		System.out.println("Generate passwords randomly where feasible");
		System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
		System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences,\nusernames, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates).");
		System.out.println("Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user");
		System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
	}
    static void requestPassword()
    {
        boolean IncludeUpper=false;
		boolean IncludeLower=false;
		boolean IncludeNum=false;
		boolean IncludeSym=false;
		String Input;
		Scanner scan = new Scanner (System.in);
        System.out.println();
		System.out.println("Hello, welcome to the Password Generator :) answer"+" the following questions by Yes or No \n");
        while(true) {
			System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
	        Input = scan.nextLine();
	        if (Input.equals("YES") || Input.equals("Yes") || Input.equals("yes")) 
            {
	        	IncludeLower=true;
	        }
	        else 
            {
	        	if (!(Input.equals("NO")) && (!Input.equals("No")) && (!Input.equals("no"))) {
	        		PasswordRequestError();
	        		break;
	        	}
	        }
			System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
			Input = scan.nextLine();
			if (Input.equals("YES") || Input.equals("Yes") || Input.equals("yes")) 
            {
	        	IncludeUpper=true;
	        }
			else 
            {
	        	if (!(Input.equals("NO")) && (!Input.equals("No")) && (!Input.equals("no"))) {
	        		PasswordRequestError();
	        		break;
	        	}
	        }
			System.out.println("Do you want Numbers \"1234...\" to be used? ");
			Input = scan.nextLine();
			if (Input.equals("YES") || Input.equals("Yes") || Input.equals("yes")) 
            {
	        	IncludeNum=true;
	        }
			else 
            {
	        	if ((Input.equals("NO")==false) && (Input.equals("No")==false) && (Input.equals("no")==false)) {
	        		PasswordRequestError();
	        		break;
	        	}
	        }
			System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
			Input = scan.nextLine();
			if (Input.equals("YES") || Input.equals("Yes") || Input.equals("yes")) 
            {
	        	IncludeSym=true;
	        }
			else
            {
	        	if ((Input.equals("NO")==false) && (Input.equals("No")==false) && (Input.equals("no")==false)) {
	        		PasswordRequestError();
	        		break;
	        	}
	        }
			//No Pool Selected
			if(!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
				System.out.println("You have selected no characters to generate your password at least one of your answers should be Yes");
				break;
			}
	        System.out.println("Great! Now enter the length of the password");
	        int length=scan.nextInt();
	        final Generator generator = new Generator (IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
	        final Password UserPass = generator.GeneratePassword(length);	        
	        System.out.println(UserPass);
        }
    }
    static void PasswordRequestError() 
    {
		System.out.println("You have entered something incorrect let's go over it again \n");		
	}
    static void checkPassword() 
    {
		String input;
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter your password:");
		input = scan.nextLine();
		Password p = new Password(input);
		System.out.println(p.calculateScore());
	}
    static void printMenu() 
    {
		System.out.println();
		System.out.println("Enter 1 - Password Generator");
		System.out.println("Enter 2 - Password Stength Check");
		System.out.println("Enter 3 - Useful Information");
		System.out.println("Enter 4 - Quit");
		System.out.print("Choice:");
	}
    public static void main (String arg[])
    {
        String Input;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Ziz Password Services :)" );
		printMenu();
    }
    while (scan.hasNextLine()) 
    {
        Input = scan.nextLine();
        if (Input.equals("1")) 
        {
            requestPassword();
            printMenu();
        }
        
        else if (Input.equals("2")) 
        {
            checkPassword();
            printMenu();
        }
        
        else if (Input.equals("3")) 
        {
            printUsefulInfo();
            printMenu();
        }
        
        else if (Input.equals("4")) 
        {
            break;
        }

        else 
        {
            System.out.println();
            System.out.println("Kindly select one of the available commands" );	
            printMenu();
        }
    }
}