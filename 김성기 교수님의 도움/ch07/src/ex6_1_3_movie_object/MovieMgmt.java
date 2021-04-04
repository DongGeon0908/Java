package ex6_1_3_movie_object;

/**
 * [ Movie, MovieMgmt ]:  객체 필드 및 메소드, 객체 배열의 연습
 *  
 *   o 객체 배열
 *      - 정수 배열은 여러 정수를 저장하듯이 객체 배열은 여러 객체들을 저장하는 배열
 *      
 *      - 객체는 생성되면 참조변수에 저장되어 객체의 필드나 메소드를 접근하게 됨
 *      - 그런데 한 클래스의 여러 객체가 생성되면 이들을 전체적으로 관리할 필요가 있으며
 *        이를 위한 기본적인 방안이 생성된 객체들을 객체 배열의 원소로 저장하는 것
 *       
 *      - 객체 배열의 선언: 클래스이름[] 배열변수이름 = new 클래스이름[원소개수];
 *
 *   o 제목, 장르, 감독, 주연배우, 제작년도 등의 필드를 갖는 Movie 클래스를 이용한 객체 관리
 *   
 *     - 이 클래스에서는 객체생성 및 객체 배열에 저장, 모든 객체 보기, 영화제목, 장르, 감독, 주연배우 등의 영화를 검색
 *       등의 작업을 수행
 *         
 *     - 검색은 문자열의 비교로 이루어짐
 *     
 *     - String 타입의 값 비교하는 중요 연산자
 *         1) 문자열1.equals(문자열2): 문자열1과 문자열2가 같으면 true를, 다르면 false를 반환
 *              "Speed".equals("Speed") ==> true를 반환,  "Speed".equals("Speedo") ==> false를 반환
 *              
 *         2) 문자열1.contains(문자열2): 문자열1이 문자열2를 포함하면 true를, 포함하지 않으면 false를 반환
 *              "The Sound of Music".equals("Music") ==> true 반환,  "The Sound of Music".equals("music") ==> false 반환 
 *        
 *     - 문자열 비교에서 영소문자와 영대문자는 서로 다른 문자
 *       대소문자를 무시하면서 equals() 또는 contains()를 이용하여 비교하려면 
 *       문자열을 모두 대문자 또는 소문자로 변환하면 가능
 *       
 *     - 대소문자 변환을 위해 제공되는 메소드
 *         1) 문자열.toLowerCase():  문자열에 포함된 대문자를 모두 소문자로 변경한 문자열을 반환
 *                "The Sound of Music".toLowerCase() ==> "the sound of music" 반환 
 *                 
 *        2) 문자열.toUpperCase():  문자열에 포함된 소문자를 모두 대문자로 변경한 문자열을 반환
 *                "The Sound of Music".toUpperCase() ==> "THE SOUND OF MUSIC" 반환 
 *                
 *         그러므로 "The Sound of Music".toLowerCase().contains("music")  ==> true를 반환
 *     
 *   o 이 프로그램에서 main()을 제외한  모든 메소드는 객체 메소드로 작성
 *     - 객체 메소드는 객체 생성한 후 객체가 수신자로 호출 
 *     
 *     - 한편, 동일한 클래스의 다른 메소드를 호출할 때 수신자가 this           
 */

class Movie {

	String  title, genre, director, actors;  // 제목, 장르, 감독, 주연배우들 
	int yearMade;                            // 제작년도

	Movie() {  // 다른 객체 생성자를 작성할 경우 매개변수 없는 객체 생성자를 작성하는 것이 좋음
	}

	// 제목, 장르, 감독, 주연배우들, 제작년도가 주어지면 영화 객체 생성하는 객체 생성자
	Movie(String  title, String  genre, String director, String actors, int yearMade) {
		this.title = title;
		this.genre =  genre;
		this.director = director;
		this.actors = actors;
		this.yearMade = yearMade;
	}

	// 영화의 제목, 장르, 감독, 주연배우들을 입력하여 필드에 저장하는 입력을 위한 메소드
	void input() {
		this.title = SkScanner.getStringWithPrompt("  o 영화제목 > ");
		this.genre  = SkScanner.getStringWithPrompt("  o 장르 > ");
		this.director  = SkScanner.getStringWithPrompt("  o 감독 > ");
		this.actors  = SkScanner.getStringWithPrompt("  o 주연배우들 > ");
		this.yearMade = SkScanner.getIntWithPrompt("  o 제작년도 > ");
	}

	// 입력을 위한 타이틀 출력 후 영화의 제목, 장르, 감독, 주연배우들을 입력하여 필드에 저장하는 입력을 위한 메소드
	void input(String title) {
		System.out.println(title);  // 입력을 위한 타이틀 출력
		input();                    // 필드를 입력
	}

	// 객체의 필드 값들을 문자열로 만들어 반환하는 메소드.
	public String toString() {
		return "제목: '" + this.title + "',  장르: '" + this.genre 
				+ "',  감독: '" + director  + "',  주연배우들: '" + actors + "', 제작연도: " + yearMade;
	}

	// 객체의 필드 값들 출력하기 위한 메소드
	//   toString() 메소드를 이용하여 처리
	void output(String message) {
		System.out.println("  " + message + " - " + this.toString());
		// 위의 문장은 다음의 문장들과 동일한 문장임
		// System.out.println("  " + message + " - " + toString());  // < this. >은 생략되어도 됨
		// System.out.println("  " + message + " - " + this);  // println() 메소드에서 객체 변수 출력은 toString() 메소드를 자동적으로 호출하여 출력

	}
}

class MovieMgmt  {
	// Movie 객체 200개를 저장할 수 있는 배열 변수 movies 선언 및 배열 객체 저장
	Movie movies[] = new Movie[200];  // 배열 변수는 반드시 < 타입명 배열변수 = new 타입명[원소개수] >로 배열 객체 생성 후 저장해야 함!!!!!

	public static void main(String[] args) {
		MovieMgmt mms = new MovieMgmt();

		mms.setupInitialMovies();  // 주어진 영화 정보들로 여러 영화 객체들을 생성 후 movies[] 객체 배열에 저장

		int menu = 0;

		while(menu != 7) {
			menu = mms.displayGetMenu();

			if (menu==7)  {  // 종료 선택 시
				mms.outputResult("  !! 영화 관리를 종료합니다. Bye!!!");     // 종료 메시지 출력 후
				break;                                          // while 문을 벗어나 종료함(< return menu; >을 이용하여도 같은 효과임)
			}	

			mms.doWork(menu);
		}
	}

	// 주어진 초기 영화정보로 영화 객체 생성하여 movies[] 객체 배열에 저장하는 메소드
	//  이 메소드는 메뉴가 수행되기 전에 호출됨
	void setupInitialMovies() {
		this.createAddMovie("Ben Her, Ben-Her(벤허)",                 "adventure/drama",  "William Wyler",  "Charlton Heston, Jack Hawkins, Stephen Boyd",         1959);
		this.createAddMovie("The Sound Of Music(사운드 오브 뮤직)",   "musical/drama",    "Robert Wise",    "Julie Andrews, Christopher Plummer, Eleanor Parker",  1965);
		this.createAddMovie("2001: A Space Odyssey",   "Adventure/SF","Stanley Kubrick",  "Keir Dullea, Gary Lockwood, William Sylvester",                         1968);

		this.createAddMovie("Speed(스피드)",           "action",        "Jan de Bont(쟝 드봉)",  "Keanu Reeves, Dennis Hopper, Sandra Bullock",  1994);
		this.createAddMovie("Toy Story(토이 스토리)",  "animation",     "John Lasseter",         "Tom Hanks, Tim Allen, Don Rickles",            1995);
		this.createAddMovie("Titanic(타이타닉)",       "drama/romance", "James Cameron",        "Leonardo DiCaprio, Kate Winslet, Billy Zane",   1997);
		this.createAddMovie("Matrix(매트릭스",         "action/SF",     "Andy Wachowski, Lana Wachowski",   "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss",  1999);

		this.createAddMovie("Artificial Intelligence: A.I.", "adventure/SF","Steven Spielberg",  "Haley Joel Osment, Jude Law, Frances O'Connor",            2001 );
		this.createAddMovie("The Lord of the Rings(반지의 제왕)",  "action/adventure/fantasy",   "Peter Jackson",  "Elijah Wood, Ian McKellen, Orlando Bloom",            2001 );
		this.createAddMovie("Harry Potter and the Sorcerer's Stone(해리포터와 마법사의 돌)",     "adventure/fantasy", "Chris Columbus",    "Daniel Radcliffe, Rupert Grint, Richard Harris",   2001);
		this.createAddMovie("Transformer(트랜스포머)",            "action/SF",                   "Michael Bay",    "Shia LaBeouf, Megan Fox, Josh Duhamel",               2007);
		this.createAddMovie("Iron Man(아이언 맨)",                "action/adventure/SF",         "Jon Favreau",    "Robert Downey Jr., Gwyneth Paltrow, Terrence Howard", 2008);
		this.createAddMovie("Surrogates(써로게이트)",             "action/thriller/SF",          "Jonathan Mostow ","Bruce Willis, Radha Mitchell, Ving Rhames", 2009);

		this.createAddMovie("Kwanghea(광해)",    "drama",      "Changmin Choo",                  "Byounghyoun Lee, Hyojoo Han, Sungryoung Ryu",  2012);
		this.createAddMovie("Gravity(그래비티)", "drama",      "Alfonso Cuaron(알폰소 쿠아론)",  "Sandra Bullock, George Clooney, Ed Harris",    2013);
		this.createAddMovie("Frozen(겨울왕국)",  "animation",  "Chris Buck, Jennifer Lee",       "Kristen Bell, Josh Gad, Idina Menzel",         2013);
		this.createAddMovie("Amazing Spiderman 2(어메이징 스파이더맨2)",  "action/adventure/SF", "Marc Webb(마크 웹)", "Andrew Garfield, Emma Stone, Jamie Foxx, Dane DeHaan. Peter Parker",  2014);
		this.createAddMovie("Roaring Currents(명량)",  		  "action/drama", 					"Hanmin Kim", "Minsik Choi, Sungryoung Ryu, JingWoong Jo, Myounggon Kim",  2014);
		this.createAddMovie("The Avengers: Age of Ultron(어벤전스2)",     "action/SF",           "Joss Whedon", "Robert Downey Jr., Chris Evans, Mark Ruffalo",  2015);
	}

	int displayGetMenu() {
		int menu;

		while(true) {			// 종료가 선택될 때까지 반복 수행
			System.out.println("\n\n       **** 영화 관리 시스템 ****\n");
			System.out.println("  1) 새로운 영화 등록               2) 모든 영화 검색");
			System.out.println("  3) 제목으로 영화 검색            4) 장르로 영화 검색");
			System.out.println("  5) 감독 이름으로 영화 검색      6) 주연배우 이름으로 영화 검색");
			System.out.println("  7) 종료");

			menu  = this.getIntWithPrompt("선택", 1, 7);  // getIntWithPrompt()로 1에서 7 사이 메뉴 정수값 선택

			if (menu >=1 && menu <= 7)   // 올바른 메뉴 번호가 입력되면 그 번호를 반환
				return menu;
		}
	}

	void doWork(int menu) {
		switch(menu) {
		case 1:
			this.getEnrolMovie();    // 새로운 영화 등록 
			break;

		case 2:
			this.showAllMovies();    // 모든 영화 검색하여 보기
			break;

		case 3:
			this.showMovieByTitle(); // 제목으로 검색하여 보기
			break;		   		

		case 4:
			this.showMovieByGenre(); // 장르로 검색하여 보기
			break;
		case 5:
			this.showMovieByDirector();  // 감독으로 검색하여 보기 - 이 메소드를 완성하시오
			break;		   		

		case 6:
			this.showMovieByActors();    // 주연배우로 검색하여 보기 - 이 메소드를 완성하시오
			break;
		}
	}

	// 영화 정보가 주어지면 영화 객체 생성하고 이를 주어진 movies[] 객체 배열에 저장
	Movie createAddMovie(String title, String genre, String director, String actors, int yearMade) {  // 반환타입이 Movie이므로 Movie 객체가 반환됨
		Movie m = createMovie(title, genre, director, actors, yearMade);   // 영화 객체 생성하여 객체 참조변수 m에 저장

		this.addMovie(m);  // m이 참조하는 객체를 movies[] 객체 배열에 저장

		return m;
	}

	// 메뉴 1: 영화 정보를 입력하여 영화 객체 생성하고 객체 배열 movies[]에 저장
	void getEnrolMovie() {	
		this.outputSubtitle("새로운 영화 등록하기");

		Movie m = inputCreateMovie();  // 영화 정보를 입력하여 영화 객체 생성하고 생성된 객체를 반환받음

		this.addMovie(m);  // 생성된 객체를 객체 배열 movies[]에 저장

		this.outputResult("  !! 새로운 영화(" + m + ")가 생성되고 객체 배열 movies[]에 저장됨");
	}

	// 영화 정보를 입력받아 Movie 객체 생성하고, 생성된 객체를 반환
	Movie inputCreateMovie() { // 반환타입이 Movie이므로 Movie 객체가 반환됨

		// Movie 클래스의 input() 메소드를 이용하여 Movie 객체에 입력된 필드 저장하기
		Movie m = new Movie();   // Movie 객체 생성
		m.input();                // Movie의 여러 필드를 입력하여 저장
		
		return m;
		
//      ***** createMovie() 메소드를 이용하기 위한 코드 ****	
//		
//		String title = getStringWithPrompt("영화제목");
//		String genre  = getStringWithPrompt("장르");
//		String director  = getStringWithPrompt("감독");
//		String actors  = getStringWithPrompt("주연배우들");
//		int yearMade = getIntWithPrompt("제작년도");
//
//		return this.createMovie(title, genre, director, actors, yearMade);
	}

	// setupInitialMovies()에서 영화 정보가 주어지면 영화 객체 생성하여 반환
	Movie createMovie(String title, String genre, String director, String actors, int yearMade) { // 반환타입이 Movie이므로 Movie 객체가 반환됨

		Movie m = new Movie(title, genre, director, actors, yearMade); // 입력된 필드 값을 갖는 객체 생성하여 m에 저장

		return m;  // m을 반환
	}

	// newMovie에 저장된 Movie 객체를 객체 배열 movies[]의 처음 빈곳에 저장
	void addMovie(Movie newMovie) {
		int i;		
		for (i = 0; movies[i] != null; i++) ;  // movies 객체 배열에서 새로운 Movie 객체를 저장할,  빈 원소의 처음 위치를 찾음
		// Movie 객체가 저장 안된 원소의 값은 null임

		movies[i] = newMovie;  // 빈 원소의 처음 위치의 원소로 객체를 저장
	}

	// 메뉴 2: 객체 배열 movies[]에 저장된 모든 객체를 출력 
	void showAllMovies() {
		this.outputMovies(movies, "모든 영화들 보기", "    !! 현재 등록된 영화가 하나도 없습니다");
	}

	// 객체 배열 movies[]에 저장된 객체들을 모두 출력
	//   이때 주어진 subtitle 출력하고, 저장된 객체가 하나도 없으면 주어진 errorMSG를 출력함
	void outputMovies(Movie movies[], String subtitle, String errorMSG) {

		this.outputSubtitle(subtitle);

		if (movies[0] == null) {
			this.outputResult(errorMSG);
		}
		else {
			this.outputNewLine();

			for (int i = 0; movies[i] != null; i++) {
				movies[i].output("    " + (i + 1) + "번째 영화"); 

				if (i % 10 == 9)
					this.outputNewLine();  // 매 10줄마다 빈 줄을 하나 출력함
			}
		}
	}

	// 메뉴 3: 필드인 객체 배열 movies[]의 영화 중에서 입력된 제목의 영화를 검색하여 출력하기
	void showMovieByTitle() {
		this.outputSubtitle("입력된 제목을 포함하는 영화를 검색하여 출력");

		if (movies[0] == null) {
			this.outputResult("  !! 영화가 하나도 없으므로 검색할 수 없습니다.");
		}
		else { 
			String titleToSearch  = getStringWithPrompt("검색할 제목");

			Movie[] moviesSearched = searchMovieByTitle(titleToSearch);

			this.outputMovies(moviesSearched, "전체 영화 중 제목에 '" + titleToSearch + "'을(를) 포함한 영화들", 
					"  !!  제목에 '" + titleToSearch + "'을(를) 포함한 영화가 하나도 없습니다");
		}
	}

	// 필드인 객체 배열 movies[]의 영화 중에서 제목이 titleToSearch를 포함하는 영화를 찾아 이들 모두를 반환
	Movie[] searchMovieByTitle(String titleToSearch) {
		int noMovies = movies.length;  // movies[] 배열 객체의 원소 개수를 구함

		Movie moviesSearched[] = new Movie[noMovies];   // moviesSearched[] 배열의 선언과 배열 객체 저장(원소 개수는 movies[] 배열 객체의 원소 개수와 같음)

		int cntSearched = 0;   // 탐색성공인 영화 객체의 개수를 저장하는 변수

		for (int cnt = 0; cnt < noMovies && movies[cnt] != null; cnt++)   // movies[]에 저장된 모든 영화에 대해(movies[cnt] != null이어야 실제 Movie 객체가 저장된 것임)
			if (movies[cnt].title.toLowerCase().contains(titleToSearch.toLowerCase()))   // 영화 제목이 입력된 제목을 포함하면(모두 소문자로 변경하여 포함된 것을 비교함)
				moviesSearched[cntSearched++] = movies[cnt];                             // 그 영화 객체를 moviesSearched[] 배열객체에 저장하고 cntSearched 1증가

		return moviesSearched; // moviesSearched[] 배열 객체를 반환
	}

	// 메뉴 4: 필드인 객체 배열 movies[]의 영화 중에서 입력된 장르의 영화를 검색하여 출력하기
	void showMovieByGenre() {
		this.outputSubtitle("입력된 장르의 영화를 검색하여 출력");

		if (movies[0] == null) {
			this.outputResult("  !! 영화가 하나도 없으므로 검색할 수 없습니다.");
		}
		else { 
			String genreToSearch  = getStringWithPrompt("검색할 장르");

			Movie[] moviesSearched = searchMovieByGenre(genreToSearch);

			this.outputMovies(moviesSearched, "전체 영화 중 '" + genreToSearch + "' 장르의 영화들", 
					"  !! '" + genreToSearch + "' 장르의 영화가 하나도 없습니다");
		}
	}		

	// 필드인 객체 배열 movies[]의 영화 중에서 장르가 genreToSearch를 포함하는 영화를 찾아 이들 모두를 반환
	Movie[] searchMovieByGenre(String genreToSearch) {
		int noMovies = movies.length;  // movies[] 배열 객체의 원소 개수를 구함

		Movie moviesSearched[] = new Movie[noMovies];  // moviesSearched[] 배열의 선언과 배열 객체 저장(원소 개수는 movies[] 배열 객체의 원소 개수와 같음)

		int cntSearched = 0;  // 탐색성공인 영화 객체의 개수를 저장하는 변수

		for (int cnt = 0; cnt < noMovies && movies[cnt] != null; cnt++)   // movies[]에 저장된 모든 영화에 대해(movies[cnt] != null이어야 실제 Movie 객체가 저장된 것임)
			if (movies[cnt].genre.toLowerCase().contains(genreToSearch.toLowerCase()))   // 영화 장르가 입력된 장르를 포함하면(모두 소문자로 변경하여 포함된 것을 비교함)
				moviesSearched[cntSearched++] = movies[cnt];                             // 그 영화 객체를 moviesSearched[] 배열객체에 저장하고 cntSearched 1증가

		return moviesSearched; // moviesSearched[] 배열 객체를 반환
	}

	// 메뉴 5: 필드인 객체 배열 movies[]의 영화 중에서 입력된 감독의 영화를 검색하여 출력하기
	void showMovieByDirector() {
		System.out.println("\n\n  !!!! Not implemented yet !!!!");
		// 작성하시오
	}

	// 메뉴 6: 필드인 객체 배열 movies[]의 영화 중에서 입력된 배우의 영화를 검색하여 출력하기
	void showMovieByActors() {
		System.out.println("\n\n  !!!! Not implemented yet !!!!");
		// 작성하시오
	}

	/*
	 * 다음의 메소드들은 편리한 입출력을 위해 거의 모든 클래스에서 사용되는 메소드들임
	 * 
	 *   지금은 class MovieArray의 메소드로 작성되지만 나중에는 SkScanner 클래스 또는 SkOutput 클래스의 메소드로
	 *   작성될 것임
	 */

	// 프로그램의 전체 타이틀 출력(먼저 3줄을 띄운 후 타이틀 출력 후 2줄을 띄움)
	void outputTitle(String title) {
		System.out.println("\n\n\n  **** " + title + " ****\n");
	}

	// 프로그램의 부타이틀 출력(먼저 2줄을 띄운 후 부타이틀 출력 후 1줄을 띄움)
	void outputSubtitle(String subtitle) {
		System.out.println("\n\n  ** " + subtitle + " **");
	}

	// 프로그램 종료 메시지를 출력
	void outputEnding(String ending) {
		System.out.println("\n\n  !!!! " + ending + " Bye!!!!");
	}


	// 줄바꿈을 하여 새로운 줄에서 출력이 되게 함
	void outputNewLine() {
		System.out.println();
	}

	// 줄바꿈을 한 후 주어진 결과 문자열 출력
	void outputResult(String rst) {
		System.out.println("\n" + rst);
	}

	// 프롬프트 메시지를 출력한 후 같은 줄에서 정수값을 읽어 반환
	int getIntWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getInt();		
	}

	// 프롬프트 메시지를 출력한 후 min에서 max 사이의 정수값을 읽어 반환
	int getIntWithPrompt(String prompt, int min, int max) {
		int n;

		do  {
			System.out.print("\n  o " + prompt + "(" + min + "에서 " + max + "까지) > ");

			n = SkScanner.getInt();	
		} while (n < min || n > max);

		return 	n;
	}
	
	// 프롬프트 메시지를 출력한 후 실수값을 읽어 반환
	double getDoubleWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getDouble();		
	}

	// 프롬프트 메시지를 출력한 후 문자열을 읽어 반환
	String getStringWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getString();		
	}
}

/* 
 *  [ 실습 과제 ]
 *  
 *     1. 미완성 부분인 void showMovieByDirector(Movie movies[])과 
 *        void showMovieByActors(Movie movies[])을 완성하라.    
 */
