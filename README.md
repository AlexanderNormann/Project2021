# Project calculator (Eksamensprojetk 2021)


Project calculator (Eksamensprojetk 2021) is a Project calculation tool that allows Alpha Solution to calculate a project for them.

The program can create an account for new users and create a project. The user can specific certain time within a project is an estimate for duration of that project. The program can calculate the total amount of time and price for a project. 

## Prerequisites

Before you begin, ensure you have met the following requirements:
Install an IDEA like Intellj or Eclipse and MySQL Workbench. Also you have a Git Bash Terminal
You have installed the latest version of Java/HTML/CSS


## Installing Project calculator (Eksamensprojetk 2021)

To install Project calculator (Eksamensprojetk 2021), follow these steps:

1.	Make sure your java, spring and MySQL workbench is up to date
2.	Copy and paste the link: git clone https://github.com/AlexanderNormann/Project2021.git into your Git Bash terminal
3.	In MySQL Workbench, find “server” in the tap then click “Data Import” and find the SQL Dump File, which is located under resources


To use Project calculator from Heroku (Eksamensprojetk 2021)

Heroku guide til hosting af projekt og database (Vi tager udgangspunkt i person der skal deploye programmet bruger sin egen GitHub-konto og projektet ligger på personens GitHub)

1.	Login på Heroku
2.	Tryk på ”New” i øvre højre
3.	Angiv et ønsket navn til ”App name” og vælg Europa i ”Choose a region”
4.	I menubaren oppe i toppen tryk på ”Deploy”
5.	I venstre side er det er menupunkt som hedder ”Deplyoment method” vælg GitHub
6.	Der kommer nu din GitHub username frem, til venstre for den vælg det respository hvor projeket ligger i
7.	Gå et menuvalg og vælg den branch hvor projeket ligger i (i vores tilfælde er det master-branch)
8.	Tryk på ”Enable Automatic Deploys”(hver gang projekt bliver opdateret i den branch man har valgt, vil det automatisk blive deployet til GitHub)
9.	Gå et menuvalg ned og vælg den branch man vil deploye (i vores tilfælde er det master-branch)
10.	Tryk på ”Deploy Branch”
11.	Projektet vil nu blive deployet, dette kan godt lidt tid, men hvis alt er gjort rigtigt, vil der nederst på side stå ”Your app was succesfully deployed”
12.	Tryk på ”Resources” oppe i menubaren
13.	Tryk på ”Add-ons” i midten til venstre i search-baren
14.	Indtast ClearDB MySQL og den viser navnet. Tryk derefter på den
15.	Der kommer et pop-up vindue hvor under ”Plan name” den selv forslår ”Ignite Free”, tryk på ”Submit Order Form”
16.	I menubaren tryk på ”Settings”
17.	I menuen til venstre gå til Config Vars, der kommer nu 4 bokse frem med oplysninger(vi tager nu udgangspunkt i vores egne Config Vars der er brugt til dette projekt)
18.	Kopier linket i boksen øverst til højre
19.	Åben MySQL Workbench
20.	Gå ind på den connection som er din root
21.	Tryk på ”Users and Privileges”
22.	Over i venstre side under schemas tryk på ”Administration” og tryk ”Add Account”
23.	I ”Login Name” indtast:(info findes i bilag i rapport) og I “Password” indtast: (info findes i bilag i rapport), tryk derefter på ”Administrative Roles” i menubaren over
24.	Vælg ”DBA” og så burde alle felter gerne blive krydset af og tryk til sidst på ”Apply” nede til højre
25.	På velkomstsiden i midten til højre for hvor der står ”MySQL Connections” tryk ikonet med plus inde i en ring
26.	Der kommer et pop-up vindue op, hvor der øverst står ”Connection Name”, skal er indsættes navnet på connectionen: (info findes i bilag i rapporten) og i ”Hostname” skal der stå: (info findes i bilag i rapporten) og i ”Username” skal brugernavnet stå: (info findes i bilag i rapporten) I ”Password” tryk på ”Store in Vault”, kopier fra Config Vars: (info findes i bilag i rapporten) og sæt ind. Det er passwordet
27.	Tryk på ”Test Connection” og der skulle gerne sige ”Succesfully made the MySQL connection”
28.	Nu er database oprette og inde i database ville de tabeller som er oprette allerede være der


Add run commands and examples you think users will find useful. Provide an options reference for bonus points!

## Using our Project Calculator

To use our Project Calculator, follow these steps:

1.	Create an account
2.	Use the information you typed in create account to login
3.	Now you can create an project

## To contribute to Project calculator (Eksamensprojetk 2021), follow these steps:



1. Fork this repository.
2. Create a branch: `git checkout -b <branch_name>`.
3. Make your changes and commit them: `git commit -m '<commit_message>'`
4. Push to the original branch: `git push origin <project_name>/<location>`
5. Create the pull request.

Alternatively see the GitHub documentation on [creating a pull request](https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request).

## Contributors

Thanks to the following people who have contributed to this project:
  *@AlexanderNormann 
  *@Nicklas00 
  *@jona826b




## Contact

  alex654v@stud.kea.dk

  nick553h@stud.kea.dk

  jona00k3@stud.kea.dk
	

