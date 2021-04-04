package ex10_4_movie_object_using_vector_implements_more;

import java.util.Vector;   // Vector 객체에 여러 Movie 객체를 저장하기 위하여 import


/*
 *  [ MovieMgmt.java ]:  객체 필드 및 메소드, Vector 객체 등의 연습
 *  
 ***************************************************************************************
 *  o Vector 객체
 *    - 정수 배열은 여러 정수를 저장하듯이 Vector 객체은 여러 객체들을 저장하는 배열임
 *      
 *    - 객체는 생성되면 레퍼런스 변수에 저장되어 객체의 필드나 메소드를 접근하게 됨
 *    - 그런데 한 클래스의 여러 객체가 생성되면 이들을 한번에 관리할 필요성이 발생하고
 *      이를 위한 기본적인 방안이 생성된 객체들을 Vector 객체의 원소로 저장하는 것임
 *       
 *    - Vector 객체의 선언은 < Vector<클래스이름> 배열변수이름 = new 클래스이름[원소개수]; >
 *      
 *****************************************************************************************
 *
 * o java.util.Vector 클래스
 *   - 배열보다 여러 데이터를 편리하게 저장하고 검색하는 기능을 제공하는 클래스
 *   - Vector 객체에 저장되는  여러 데이터 중  하나를 원소라 함
 *   
 *   - 사용하기 위해서 반드시 import 해야 함
 *    import java.util.Vector;   // java.util.Vector를 반드시 import
 *   
 *   - 여러 데이터 저장하기 위한 Vector 객체 생성 및 참조변수에 저장    
 *     Vector<저장할-원소-클래스> 참조변수 = new Vector<저장할-원소-클래스>();  // 저장할 원소 클래스를 <와 > 사이에 표시함
 *     
 *     Vector<String> locs = new Vector<String>(); // 여러 위치의 문자열 저장하기 위한 vector 객체 생성하여 locs가 참조하게 함
 *     Vector<Book> booksBuying = new Vector<Book>();  // 여러 구매한 책 저장하기 위한 vector 객체 생성하여 booksBuying이 참조하게 함
 *     
 *   - 원소 저장하고 검색하기 위한 메소드
 *   
 *     void add(Object o): Vector 객체의 끝  위치에 원소 o를 저장하는 메소드
 *     Object get(int index): Vector 객체의 위치 index에 저장된 원소를 구하여 반환하는  메소드(index는 0부터 시작)
 *         
 *   - Vector 객체에 원소 저장하기  
 *     locs.add("광화문");   // "광화문"을 locs에 추가
 *     booksBuying.add(b);     // 책 객체 b를 booksBuying에 추가
 *     
 *   - Vector 객체에 저장된 i번째 위치의 원소 구하기       
 *     String loc = locs.get(0);  // locs에 저장된 원소들 중 첫 원소를 구해 loc에 저장
 *     Book b = booksBuying.get(booksBuying.size() -1);  // booksBuying에 저장된 원소들 중 마지막 원소를 구해 b에 저장   
 *     
 *   - Vector 객체에 저장된 i번째 위치의 원소 삭제하기       
 *     remove(int index) 메소드 사용하여 index 위치의 원소 삭제
 *     
 *     locs.remove(0);  // locs에 저장된 원소들 중 첫 원소를 삭제
 *     booksBuying.remove(booksBuying.size() -1);  // booksBuying에 저장된 원소들 중 마지막 원소를 삭제
 *      
 *****************************************************************************************
 *
 *   o 제목, 장르, 감독, 주연배우, 제작년도 등의 필드를 갖는 Movie 클래스를 이용한 객체 관리
 *   
 *     - 이 클래스에서는 객체생성 및 Vector 객체에 저장, 모든 객체 보기, 영화제목, 장르, 감독, 주연배우 등의 영화를 검색
 *       등의 작업을 수행함
 *       
 *     - 검색은 문자열의 비교로 이루어지는데 String 타입의 값을 비교하는 중요 연산자로
 *         1) 문자열1.equals(문자열2): 문자열1과 문자열2가 같으면 true를, 다르면 false를 반환
 *              "Speed".equals("Speed") ==> true를 반환,  "Speed".equals("Speedo") ==> false를 반환
 *              
 *         2) 문자열1.contains(문자열2): 문자열1이 문자열2를 포함하면 true를, 포함하지 않으면 false를 반환
 *              "The Sound of Music".equals("Music") ==> true 반환,  "The Sound of Music".equals("music") ==> false 반환 
 *        
 *     - 문자열 비교에서 영소문자와 영대문자는 서로 다른 문자로 비교됨. 
 *       대소문자를 무시하면서 equals() 또는 contains()를 이용하여 비교하려면 
 *       문자열을 모두 대문자 또는 소문자로 변환하면 가능함.
 *       
 *     - 대소문자 변환을 위해 제공되는 메소드로
 *         1) 문자열.toLowerCase():  문자열에 포함된 대문자를 모두 소문자로 변경한 문자열을 반환
 *                "The Sound of Music".toLowerCase() ==> "the sound of music" 반환 
 *                 
 *        2) 문자열.toUpperCase():  문자열에 포함된 소문자를 모두 대문자로 변경한 문자열을 반환
 *                "The Sound of Music".toUpperCase() ==> "THE SOUND OF MUSIC" 반환 
 *                
 *         그러므로 "The Sound of Music".toLowerCase().contains("music")  ==> true를 반환
 *     
 *   o 이 프로그램에서 main()을 제외한  모든 메소드는 객체 메소드로 작성되어 있다.
 *     객체 메소드는 객체를 생성한 후 객체가 수신자로 호출된다. 
 *     
 *     한편, 동일한 클래스의 다른 메소드를 호출할 때에는 수신자가 this가 된다.
 *    
 *****************************************************************************************             
 */


class Movie {

	String  title, genre, director, actors;  // 제목, 장르, 감독, 주연배우들 
	int yearMade;                            // 제작년도

	Movie() {  // 다른 객체 생성자를 작성할 경우 매개변수 없는 객체 생성자를 작성하는 것이 좋음
	}

	// 제목, 장르, 감독, 주연배우들, 제작년도가 주어지면 영화 객체를 생성하는 객체 생성자
	Movie(String  title, String  genre, String  director,String  actors, int yearMade) {
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
	void input(String titel) {
		System.out.println(title);  // 입력을 위한 타이틀 출력
		input();                    // 필드를 입력
	}

	// 객체의 필드 값들을 문자열로 만들어 반환하는 메소드.
	public String toString() {
		return "제목: '" + this.title + "',  장르: '" + this.genre 
				+ "',  감독: '" + director  + "',  주연배우들: '" + actors + "', 제작연도: " + yearMade;
	}

	// 객체의 필드 값들을 출력하기 위한 메소드
	//   toString() 매소들르 이용하여 처리함
	void output(String message) {
		System.out.println("  " + message + " - " + this.toString());
		// 위의 문장은 다음의 문장들과 동일한 문장임
		// System.out.println("  " + message + " - " + toString());  // < this. >은 생략되어도 됨
		// System.out.println("  " + message + " - " + this);  // println() 메소드에서의 레퍼런스 변수 출력은 toString() 메소드를 자동적으로 호출하여 처림함

	}
}


class MovieMgmt  {
	// Movie 객체 저장할 수 있는  Vector 객체 참조변수 movies 선언 및 Vector 객체 저장
	Vector<Movie> movies = new Vector<Movie>();  // Vector 참조변수는 반드시 < Vector<원소타입> 참조변수 = new Vector<참조변수>(); >로 Vector 객체를 생성 후 저장해야 함!!!!!

	// 작업을 나타내는 메뉴들: displayMenus() 메소드로 자동적으로 메뉴를 디스플레이하도록 함
	static String[] menus = {
		"새로운 영화 등록",       "모든 영화 검색",           "제목으로 영화 검색",     "장르로 영화 검색",
		"감독 이름으로 영화 검색",   "주연배우 이름으로 영화 검색",    "영화 선택하여 삭제",     "종료"
	};
		
	static int EndMenuNo = menus.length;  // 마지막 메뉴는 항상 종료 메뉴로 가정함, 종료 메뉴 번호는 메뉴 개수
	
	public static void main(String[] args) {
		MovieMgmt mms = new MovieMgmt();

		mms.setupInitalMovies();  // 주어진 영화 정보들로 여러 영화 객체들을 생성 후 movies Vector 객체에 저장

		int menuNo = 0;

		while(menuNo != EndMenuNo) {
			menuNo = mms.displayGetMenu("\n\n       **** 영화 관리 시스템 ****\n", menus); // 메뉴 출력 후 메뉴 번호 입력

			if (menuNo == EndMenuNo)  {  // 종료 선택시
				mms.outputResult("  !! 영화 관리를 종료합니다. Bye!!!");  // 종료 메세지 출력 후
				break;                                             // while 문을 벗어나 종료함(< return menu; >을 이용하여도 같은 효과임)
			}	

			mms.doWork(menuNo);
		}
	}

	// 주어진 초기 영화정보로 영화 객체를 생성하여 movies Vector 객체에 저장하는 메소드
	//  이 메소드는 메뉴가 수행되기 전에 호출됨
	void setupInitalMovies() {
		this.createAddMovie("Ben Her, Ben-Her(벤허)",                 "adventure/drama",  "William Wyler",  "Charlton Heston, Jack Hawkins, Stephen Boyd",         1959);
		this.createAddMovie("The Sound Of Music(사운드 오브 뮤직)",   "musical/drama",    "Robert Wise",    "Julie Andrews, Christopher Plummer, Eleanor Parker",  1965);
		this.createAddMovie("2001: A Space Odyssey",   "Adventure/SF","Stanley Kubrick",  "Keir Dullea, Gary Lockwood, William Sylvester",                         1968);

		this.createAddMovie("Speed(스피드)",           "action",        "Jan de Bont(쟝 드봉)",  "Keanu Reeves, Dennis Hopper, Sandra Bullock",  1994);
		this.createAddMovie("Toy Story(토이 스토리)",  "animation",     "John Lasseter",         "Tom Hanks, Tim Allen, Don Rickles",            1995);
		this.createAddMovie("Titanic(타이타닉)",       "drama/romance", "James Cameron",        "Leonardo DiCaprio, Kate Winslet, Billy Zane",   1997);
		this.createAddMovie("Matrix(매트릭스)",         "action/SF",     "Andy Wachowski, Lana Wachowski",   "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss",  1999);

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

	int displayGetMenu(String menuTitle, String[] menus) {
		int cntMenus = menus.length ; 
		int menu = 0;
		
		System.out.println(menuTitle);

		while(true) {			
			for (int i = 1; i <= cntMenus; i++)
				System.out.println("  " + i + ") " + menus[i-1]);

			menu  = this.getIntWithPrompt("선택", 1, cntMenus);  // getIntWithPrompt()로 1에서 cntMenus 사이의 메뉴 정수값 선택
                                         
			if (menu >=1 && menu <= cntMenus)   // 올바른 메뉴 번호가 입력되면 그 번호를 반환
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
			this.showMovieByDirector();  // 감독으로 검색하여 보기 - 미완성된 메뉴 완성함
			break;		   		

		case 6:
			this.showMovieByActors();    // 주연배우로 검색하여 보기 - 이 메소드를 완성하시오
			break;

		case 7:
			this.deleteMovie();    // 영화 선택하여 삭제 - 메뉴 추가함
			break;

		}
	}

	// 영화 정보가 주어지면 영화 객체를 생성하고 이를 주어진 movies Vector 객체에 저장
	Movie createAddMovie(String title, String genre, String director, String actors, int yearMade) {  // 반환타입이 Movie이므로 Movie 객체가 반환됨
		Movie m = createMovie(title, genre, director, actors, yearMade);   // 영화 객체를 생성라여 레퍼런스 변수 m에 저장

		this.addMovie(m);  // m이 레퍼런스하는 객체를 movies Vector 객체에 저장

		return m;
	}


	// 메뉴 1: 영화 정보를 입력하여 영화 객체를 생성하고 Vector 객체 movies에 저장
	void getEnrolMovie() {	
		this.outputSubtitle("새로운 영화 등록하기");

		Movie m = inputCreateMovie();  // 영화 정보를 입력하여 영화 객체를 생성하고 생성된 객체를 반환받음

		this.addMovie(m);  // 생성된 객체를 Vector 객체 movies에 저장

		this.outputResult("  !! 새로운 영화(" + m + ")가 생성되고 Vector 객체 movies에 저장됨");
	}

	// 영화 정보를 입력받아 Movie 객체를 생성하고, 생성된 객체를 반환
	Movie inputCreateMovie() { // 반환타입이 Movie이므로 Movie 객체가 반환됨

		// Movie 클래스의 input() 메소드를 이용하여 Movie 객체에 입력된 필드 저장하기
		Movie m = new Movie();   // Movie 객체를 생성
		m.input();                // Movie의 여러 필드를 입력하여 저장
		
		return m;
	}

	// setupInitalMovies()에서 영화 정보가 주어지면 영화 객체를 생성하여 반환
	Movie createMovie(String title, String genre, String director, String actors, int yearMade) { // 반환타입이 Movie이므로 Movie 객체가 반환됨

		Movie m = new Movie(title, genre, director, actors, yearMade); // 입력된 필드 값을 갖는 객체를 생성하여 m에 저장

		return m;  // m을 반환
	}


	// newMovie에 저장된 Movie 객체를 Vector 객체 movies의 처음 빈곳에 저장
	void addMovie(Movie newMovie) {
		movies.add(newMovie);  //newMovie를  Vector 객체 movies의 원소로 추가
	}

	// 메뉴 2: Vector 객체 movies에 저장된 모든 객체를 출력 
	void showAllMovies() {
		this.outputMovies(movies, "모든 영화들 보기", "    !! 현재 등록된 영화가 하나도 없습니다");
	}

	// Vector 객체 movies에 저장된 객체들을 모두 출력
	//   이때 주어진 subtitle을 출력하고, 저장된 객체가 하나도 없으면 주어진 errorMSG를 출력함
	void outputMovies(Vector<Movie> movies, String subtitle, String errorMSG) {

		this.outputSubtitle(subtitle);

		if (movies.size() == 0) {
			this.outputResult(errorMSG);
		}
		else {
			this.outputNewLine();

			int cntMovies = movies.size();  // 저장된 영화 개수를 구하여 cntMovies에 저장
			
			for (int i = 0; i < cntMovies; i++) {
				movies.get(i).output("    " + (i + 1) + "번째 영화");  // i번째 원소를 get()으로 구해 출력

				if (i % 10 == 9)
					this.outputNewLine();  // 매 10줄마다 빈 줄을 하나 출력함
			}
		}
	}

	// 메뉴 3: 필드인 Vector 객체 movies의 영화 중에서 입력된 제목의 영화를 검색하여 출력하기
	void showMovieByTitle() {
		this.outputSubtitle("입력된 제목을 포함하는 영화를 검색하여 출력");

		if (movies.size() == 0) {
			this.outputResult("  !! 영화가 하나도 없으므로 검색할 수 없습니다.");
		}
		else { 
			String titleToSearch = getStringWithPrompt("검색할 제목");

			Vector<Movie> moviesSearched = searchMovieByTitle(titleToSearch);

			this.outputMovies(moviesSearched, "전체 영화 중 제목에 '" + titleToSearch + "'을(를) 포함한 영화들", 
					"  !!  제목에 '" + titleToSearch + "'을(를) 포함한 영화가 하나도 없습니다");
		}
	}

	// 필드인 Vector 객체 movies의 영화 중에서 제목이 titleToSearch를 포함하는 영화를 찾아 이들 모두를 Vector 객체에 저장하여 반환
	Vector<Movie>  searchMovieByTitle(String titleToSearch) {
		int noMovies = movies.size();  // movies Vector 객체의 원소 개수를 구함

		Vector<Movie> moviesSearched = new Vector<Movie>();   // Vector 참조변수 moviesSearched 선언하여 Vector 객체 저장 저정

		for (int cnt = 0; cnt < noMovies; cnt++) {    //  Vector 객체 필드 movies에 저장된 모든 영화에 대해
			Movie m = movies.get(cnt);                //  cnt 위치의  영화를 m에 저장하여
		
			if (movies.get(cnt).title.toLowerCase().contains(titleToSearch.toLowerCase()))   // 영화 제목이 입력된 제목을 포함하면(모두 소문자로 변경하여 포함된 것을 비교함)
				moviesSearched.add(m);                // 그 영화 객체를 Vector 객체 moviesSearched에 저장
		}
		
		return moviesSearched; //  Vector 객체  moviesSearched를 반환
	}


	// 메뉴 4: 필드인 Vector 객체 movies의 영화 중에서 입력된 장르의 영화를 검색하여 출력하기
	void showMovieByGenre() {
		this.outputSubtitle("입력된 장르의 영화를 검색하여 출력");

		if (movies.size() == 0) {
			this.outputResult("  !! 영화가 하나도 없으므로 검색할 수 없습니다.");
		}
		else { 
			String genreToSearch  = getStringWithPrompt("검색할 장르");

			Vector<Movie> moviesSearched = searchMovieByGenre(genreToSearch);

			this.outputMovies(moviesSearched, "전체 영화 중 '" + genreToSearch + "' 장르의 영화들", 
					"  !! '" + genreToSearch + "' 장르의 영화가 하나도 없습니다");
		}
	}		

	// 필드인 Vector 객체  movies의 영화 중에서 장르가 genreToSearch를 포함하는 영화를 찾아 이들 모두를 Vector 객체에 저장하여  반환
	Vector<Movie> searchMovieByGenre(String genreToSearch) {
		int noMovies = movies.size();  // movies Vector 객체의 원소 개수를 구함

		Vector<Movie> moviesSearched = new Vector<Movie>();  // Vector 참조변수 moviesSearched 선언하여 Vector 객체 저장 

		for (int cnt = 0; cnt < noMovies; cnt++) {     //  Vector 객체 필드 movies에 저장된 모든 영화에 대해
			Movie m = movies.get(cnt);                 //  cnt 위치의  영화를 m에 저장하여
			
		    if (m.genre.toLowerCase().contains(genreToSearch.toLowerCase()))   // 영화 장르가 입력된 장르를 포함하면(모두 소문자로 변경하여 포함된 것을 비교함)
				moviesSearched.add(m);                 // 그 영화 객체를 Vector 객체 moviesSearched에 저장
		}
		
		return moviesSearched; // Vector 객체 moviesSearched를 반환
	}


	// 메뉴 5: 필드인 Vector 객체 movies의 영화 중에서 입력된 감독의 영화를 검색하여 출력하기
	void showMovieByDirector() {
		this.outputSubtitle("입력된 감독을 포함하는 영화를 검색하여 출력");

		if (movies.size() == 0) {
			this.outputResult("  !! 영화가 하나도 없으므로 검색할 수 없습니다.");
		}
		else { 
			String directorToSearch  = getStringWithPrompt("검색할 영화의 감독");

			Vector<Movie> moviesSearched = searchMovieByDirector(directorToSearch);

			this.outputMovies(moviesSearched, "전체 영화 중 감독에 '" + directorToSearch + "'을(를) 포함한 영화들", 
					"  !!  제목에 '" + directorToSearch + "'을(를) 포함한 영화가 하나도 없습니다");
		}
	}

	// 필드인 Vector 객체  movies의 영화 중에서 감독이 directorToSearch를 포함하는 영화를 찾아 이들 모두를 반환
	Vector<Movie> searchMovieByDirector(String directorToSearch) {
		int noMovies = movies.size();  // movies Vector 객체의 원소 개수를 구함

		Vector<Movie> moviesSearched = new Vector<Movie>();  // Vector 객체 참조변수  moviesSearched의 선언과 Vector 객체 저장

		int cntSearched = 0;  // 탐색성공인 영화 객체의 개수를 저장하는 변수

		for (int cnt = 0; cnt < noMovies; cnt++) {  // movies에 저장된 모든 영화에 대해
			Movie m =  movies.get(cnt);
			if (m.director.toLowerCase().contains(directorToSearch.toLowerCase()))   // 영화 장르가 입력된 장르를 포함하면(모두 소문자로 변경하여 포함된 것을 비교함)
				moviesSearched.add(m);                             // 그 영화 객체를 Vector 객체 moviesSearched에 저장
		}
		
		return moviesSearched; // moviesSearched Vector 객체를 반환
	}

	// 메뉴 6: 필드인 Vector 객체  movies의 영화 중에서 입력된 배우의 영화를 검색하여 출력하기
	void showMovieByActors() {
		System.out.println("\n\n  !!!! Not implented yet !!!!");
		// 작성하시오
	}

	// 메뉴 7: 필드인 객체 배열 movies[]의 영화 중에서 선택된 영화를 삭제하기
	void deleteMovie() {
		this.outputMovies(movies, "삭제 가능한  모든 영화들", "    !! 현재 등록된 영화가 하나도 없으므로 삭제할 수 없습니다");
		
		if (movies.size() > 0) {
			int no = getIntWithPrompt("삭제할 영화의 번호", 1, movies.size());

			Movie m = deleteMovie(no - 1);  // no - 1위치(0부터 시작)의 영화 삭제하는 메소드 호출
			this.outputResult("  !! " + no + "번째 영화 '" + m.title + "'이 삭제되었습니다.");
		}
	}
	// 매개변수 n에 주어진 위치(위치는 0부터 시작함)의 영화를 movies[] 배열에서 삭제
	Movie deleteMovie(int n) {		
		Movie m = movies.get(n);  // 삭제될 영화를 m에 저장
		
		// Vector 객체에서 특정 위치의 원소를 삭제하는 것은 remove(int index) 메소드로 가능함
		movies.remove(n);  // index n의 위치의 우너소 삭제
		
		return m;  // 삭제된 영화를 반환
	}

	/*
	 * 다음의 메소드들은 편리한 입출력을 위해 거의 모든 클래스에서 사용되는 메소드들임
	 * 
	 */

	// 프로그램의 전체 타이틀을 출력(먼저 3줄을 뛰운 후 타이틀 출력 후 2줄을 뛰움)
	void outputTitle(String title) {
		System.out.println("\n\n\n  **** " + title + " ****\n");
	}

	// 프로그램의 부타이틀을 출력(먼저 2줄을 뛰운 후 부타이틀 출력 후 1줄을 뛰움)
	void outputSubtitle(String subtitle) {
		System.out.println("\n\n  ** " + subtitle + " **");
	}

	// 프로그램 종료 메세지를 출력
	void outputEnding(String ending) {
		System.out.println("\n\n  !!!! " + ending + " Bye!!!!");
	}


	// 줄바꿈을 하여 새로운 줄에서 출력이 되게 함 - 이 메소드를 호출할 때에는 결과 출력에 대해서만 생각하면됨
	void outputNewLine() {
		System.out.println();
	}

	// 줄바꿈을 한 후 주어진 결과 문자열을 출력 - 이 메소드를 호출할 때에는 결과 출력에 대해서만 생각하면됨
	void outputResult(String rst) {
		System.out.println("\n" + rst);
	}

	// 프롬프트 메세지를 출력한 후 같은 줄에서 정수값을 읽어 반환
	int getIntWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getInt();		
	}

	// 프롬프트 메세지를 출력한 후 min에서 max 사이의 정수값을 읽어 반환
	int getIntWithPrompt(String prompt, int min, int max) {
		int n;

		do  {
			System.out.print("\n  o " + prompt + "(" + min + "에서 " + max + "까지) > ");

			n = SkScanner.getInt();	
		} while (n < min || n > max);

		return 	n;
	}
	// 프롬프트 메세지를 출력한 후 실수값을 읽어 반환
	double getDoubleWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getDouble();		
	}

	// 프롬프트 메세지를 출력한 후 문자열을 읽어 반환
	String getStringWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getString();		
	}
}

/* 
 *  [ 실습 과제 ]
 *  
 *    1. 미완성 부분인 void showMovieByDirector()와   void showMovieByActors()을 완성하라.    
 *        
 *    2. 전체 영화 중에서 영화를 하나 선택하여 삭제하는 메뉴 "영화 삭제"를 7번 메뉴로 추가하도록 프로그램을 변경하려한다.
 *       새로운 메뉴가 추가되면 종료 메뉴는 8번이 된다.
 *       
 *       전체 영화를 나열한 후 삭제할 영화의 번호를 입력받은 후 해당 영화를 삭제하는 removeMovie() 메소드를 작성하라. 
 *       
 *       Vector 객체에서 위치 index의 원소를 삭제하기 위해서는  void remove(int index) 메소드를 사용한다.  
 *       예를 들어, Vector 객체  movies에서 0 위치의 원소를 삭제하는 코드는 << movies.remove(0); >>이다.
 */
