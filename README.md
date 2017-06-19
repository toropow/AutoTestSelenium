Добрый день!

Для запуска теста необходимо наличие IDEA, Mozilla Firefox.
Чтобы запустить тест под ОС Widows нужно в классе CheckPage расскомментировать строку с коментарием "For Windows", для Debian образных ОС
нужно раскомментировать строку "For Linux" и закомметнировать строчку для Windows. 

        //System.setProperty("webdriver.gecko.driver","/home/anton/Documents/newFireFox/geckodriver"); //For Linux
        System.setProperty("webdriver.gecko.driver","src/test/resources/geckodriver.exe"); // For Windows
	
Склонировав с гит хаба проект, перейдите в класс CheckPage и нажмите Ctrl+ Shift + F10.
