package ex10_4_movie_object_using_vector_implements_more;

import java.util.Vector;   // Vector ��ü�� ���� Movie ��ü�� �����ϱ� ���Ͽ� import


/*
 *  [ MovieMgmt.java ]:  ��ü �ʵ� �� �޼ҵ�, Vector ��ü ���� ����
 *  
 ***************************************************************************************
 *  o Vector ��ü
 *    - ���� �迭�� ���� ������ �����ϵ��� Vector ��ü�� ���� ��ü���� �����ϴ� �迭��
 *      
 *    - ��ü�� �����Ǹ� ���۷��� ������ ����Ǿ� ��ü�� �ʵ峪 �޼ҵ带 �����ϰ� ��
 *    - �׷��� �� Ŭ������ ���� ��ü�� �����Ǹ� �̵��� �ѹ��� ������ �ʿ伺�� �߻��ϰ�
 *      �̸� ���� �⺻���� ����� ������ ��ü���� Vector ��ü�� ���ҷ� �����ϴ� ����
 *       
 *    - Vector ��ü�� ������ < Vector<Ŭ�����̸�> �迭�����̸� = new Ŭ�����̸�[���Ұ���]; >
 *      
 *****************************************************************************************
 *
 * o java.util.Vector Ŭ����
 *   - �迭���� ���� �����͸� ���ϰ� �����ϰ� �˻��ϴ� ����� �����ϴ� Ŭ����
 *   - Vector ��ü�� ����Ǵ�  ���� ������ ��  �ϳ��� ���Ҷ� ��
 *   
 *   - ����ϱ� ���ؼ� �ݵ�� import �ؾ� ��
 *    import java.util.Vector;   // java.util.Vector�� �ݵ�� import
 *   
 *   - ���� ������ �����ϱ� ���� Vector ��ü ���� �� ���������� ����    
 *     Vector<������-����-Ŭ����> �������� = new Vector<������-����-Ŭ����>();  // ������ ���� Ŭ������ <�� > ���̿� ǥ����
 *     
 *     Vector<String> locs = new Vector<String>(); // ���� ��ġ�� ���ڿ� �����ϱ� ���� vector ��ü �����Ͽ� locs�� �����ϰ� ��
 *     Vector<Book> booksBuying = new Vector<Book>();  // ���� ������ å �����ϱ� ���� vector ��ü �����Ͽ� booksBuying�� �����ϰ� ��
 *     
 *   - ���� �����ϰ� �˻��ϱ� ���� �޼ҵ�
 *   
 *     void add(Object o): Vector ��ü�� ��  ��ġ�� ���� o�� �����ϴ� �޼ҵ�
 *     Object get(int index): Vector ��ü�� ��ġ index�� ����� ���Ҹ� ���Ͽ� ��ȯ�ϴ�  �޼ҵ�(index�� 0���� ����)
 *         
 *   - Vector ��ü�� ���� �����ϱ�  
 *     locs.add("��ȭ��");   // "��ȭ��"�� locs�� �߰�
 *     booksBuying.add(b);     // å ��ü b�� booksBuying�� �߰�
 *     
 *   - Vector ��ü�� ����� i��° ��ġ�� ���� ���ϱ�       
 *     String loc = locs.get(0);  // locs�� ����� ���ҵ� �� ù ���Ҹ� ���� loc�� ����
 *     Book b = booksBuying.get(booksBuying.size() -1);  // booksBuying�� ����� ���ҵ� �� ������ ���Ҹ� ���� b�� ����   
 *     
 *   - Vector ��ü�� ����� i��° ��ġ�� ���� �����ϱ�       
 *     remove(int index) �޼ҵ� ����Ͽ� index ��ġ�� ���� ����
 *     
 *     locs.remove(0);  // locs�� ����� ���ҵ� �� ù ���Ҹ� ����
 *     booksBuying.remove(booksBuying.size() -1);  // booksBuying�� ����� ���ҵ� �� ������ ���Ҹ� ����
 *      
 *****************************************************************************************
 *
 *   o ����, �帣, ����, �ֿ����, ���۳⵵ ���� �ʵ带 ���� Movie Ŭ������ �̿��� ��ü ����
 *   
 *     - �� Ŭ���������� ��ü���� �� Vector ��ü�� ����, ��� ��ü ����, ��ȭ����, �帣, ����, �ֿ���� ���� ��ȭ�� �˻�
 *       ���� �۾��� ������
 *       
 *     - �˻��� ���ڿ��� �񱳷� �̷�����µ� String Ÿ���� ���� ���ϴ� �߿� �����ڷ�
 *         1) ���ڿ�1.equals(���ڿ�2): ���ڿ�1�� ���ڿ�2�� ������ true��, �ٸ��� false�� ��ȯ
 *              "Speed".equals("Speed") ==> true�� ��ȯ,  "Speed".equals("Speedo") ==> false�� ��ȯ
 *              
 *         2) ���ڿ�1.contains(���ڿ�2): ���ڿ�1�� ���ڿ�2�� �����ϸ� true��, �������� ������ false�� ��ȯ
 *              "The Sound of Music".equals("Music") ==> true ��ȯ,  "The Sound of Music".equals("music") ==> false ��ȯ 
 *        
 *     - ���ڿ� �񱳿��� ���ҹ��ڿ� ���빮�ڴ� ���� �ٸ� ���ڷ� �񱳵�. 
 *       ��ҹ��ڸ� �����ϸ鼭 equals() �Ǵ� contains()�� �̿��Ͽ� ���Ϸ��� 
 *       ���ڿ��� ��� �빮�� �Ǵ� �ҹ��ڷ� ��ȯ�ϸ� ������.
 *       
 *     - ��ҹ��� ��ȯ�� ���� �����Ǵ� �޼ҵ��
 *         1) ���ڿ�.toLowerCase():  ���ڿ��� ���Ե� �빮�ڸ� ��� �ҹ��ڷ� ������ ���ڿ��� ��ȯ
 *                "The Sound of Music".toLowerCase() ==> "the sound of music" ��ȯ 
 *                 
 *        2) ���ڿ�.toUpperCase():  ���ڿ��� ���Ե� �ҹ��ڸ� ��� �빮�ڷ� ������ ���ڿ��� ��ȯ
 *                "The Sound of Music".toUpperCase() ==> "THE SOUND OF MUSIC" ��ȯ 
 *                
 *         �׷��Ƿ� "The Sound of Music".toLowerCase().contains("music")  ==> true�� ��ȯ
 *     
 *   o �� ���α׷����� main()�� ������  ��� �޼ҵ�� ��ü �޼ҵ�� �ۼ��Ǿ� �ִ�.
 *     ��ü �޼ҵ�� ��ü�� ������ �� ��ü�� �����ڷ� ȣ��ȴ�. 
 *     
 *     ����, ������ Ŭ������ �ٸ� �޼ҵ带 ȣ���� ������ �����ڰ� this�� �ȴ�.
 *    
 *****************************************************************************************             
 */


class Movie {

	String  title, genre, director, actors;  // ����, �帣, ����, �ֿ����� 
	int yearMade;                            // ���۳⵵

	Movie() {  // �ٸ� ��ü �����ڸ� �ۼ��� ��� �Ű����� ���� ��ü �����ڸ� �ۼ��ϴ� ���� ����
	}

	// ����, �帣, ����, �ֿ�����, ���۳⵵�� �־����� ��ȭ ��ü�� �����ϴ� ��ü ������
	Movie(String  title, String  genre, String  director,String  actors, int yearMade) {
		this.title = title;
		this.genre =  genre;
		this.director = director;
		this.actors = actors;
		this.yearMade = yearMade;
	}

	// ��ȭ�� ����, �帣, ����, �ֿ������� �Է��Ͽ� �ʵ忡 �����ϴ� �Է��� ���� �޼ҵ�
	void input() {
		this.title = SkScanner.getStringWithPrompt("  o ��ȭ���� > ");
		this.genre  = SkScanner.getStringWithPrompt("  o �帣 > ");
		this.director  = SkScanner.getStringWithPrompt("  o ���� > ");
		this.actors  = SkScanner.getStringWithPrompt("  o �ֿ����� > ");
		this.yearMade = SkScanner.getIntWithPrompt("  o ���۳⵵ > ");
	}

	// �Է��� ���� Ÿ��Ʋ ��� �� ��ȭ�� ����, �帣, ����, �ֿ������� �Է��Ͽ� �ʵ忡 �����ϴ� �Է��� ���� �޼ҵ�
	void input(String titel) {
		System.out.println(title);  // �Է��� ���� Ÿ��Ʋ ���
		input();                    // �ʵ带 �Է�
	}

	// ��ü�� �ʵ� ������ ���ڿ��� ����� ��ȯ�ϴ� �޼ҵ�.
	public String toString() {
		return "����: '" + this.title + "',  �帣: '" + this.genre 
				+ "',  ����: '" + director  + "',  �ֿ�����: '" + actors + "', ���ۿ���: " + yearMade;
	}

	// ��ü�� �ʵ� ������ ����ϱ� ���� �޼ҵ�
	//   toString() �żҵ鸣 �̿��Ͽ� ó����
	void output(String message) {
		System.out.println("  " + message + " - " + this.toString());
		// ���� ������ ������ ������ ������ ������
		// System.out.println("  " + message + " - " + toString());  // < this. >�� �����Ǿ ��
		// System.out.println("  " + message + " - " + this);  // println() �޼ҵ忡���� ���۷��� ���� ����� toString() �޼ҵ带 �ڵ������� ȣ���Ͽ� ó����

	}
}


class MovieMgmt  {
	// Movie ��ü ������ �� �ִ�  Vector ��ü �������� movies ���� �� Vector ��ü ����
	Vector<Movie> movies = new Vector<Movie>();  // Vector ���������� �ݵ�� < Vector<����Ÿ��> �������� = new Vector<��������>(); >�� Vector ��ü�� ���� �� �����ؾ� ��!!!!!

	// �۾��� ��Ÿ���� �޴���: displayMenus() �޼ҵ�� �ڵ������� �޴��� ���÷����ϵ��� ��
	static String[] menus = {
		"���ο� ��ȭ ���",       "��� ��ȭ �˻�",           "�������� ��ȭ �˻�",     "�帣�� ��ȭ �˻�",
		"���� �̸����� ��ȭ �˻�",   "�ֿ���� �̸����� ��ȭ �˻�",    "��ȭ �����Ͽ� ����",     "����"
	};
		
	static int EndMenuNo = menus.length;  // ������ �޴��� �׻� ���� �޴��� ������, ���� �޴� ��ȣ�� �޴� ����
	
	public static void main(String[] args) {
		MovieMgmt mms = new MovieMgmt();

		mms.setupInitalMovies();  // �־��� ��ȭ ������� ���� ��ȭ ��ü���� ���� �� movies Vector ��ü�� ����

		int menuNo = 0;

		while(menuNo != EndMenuNo) {
			menuNo = mms.displayGetMenu("\n\n       **** ��ȭ ���� �ý��� ****\n", menus); // �޴� ��� �� �޴� ��ȣ �Է�

			if (menuNo == EndMenuNo)  {  // ���� ���ý�
				mms.outputResult("  !! ��ȭ ������ �����մϴ�. Bye!!!");  // ���� �޼��� ��� ��
				break;                                             // while ���� ��� ������(< return menu; >�� �̿��Ͽ��� ���� ȿ����)
			}	

			mms.doWork(menuNo);
		}
	}

	// �־��� �ʱ� ��ȭ������ ��ȭ ��ü�� �����Ͽ� movies Vector ��ü�� �����ϴ� �޼ҵ�
	//  �� �޼ҵ�� �޴��� ����Ǳ� ���� ȣ���
	void setupInitalMovies() {
		this.createAddMovie("Ben Her, Ben-Her(����)",                 "adventure/drama",  "William Wyler",  "Charlton Heston, Jack Hawkins, Stephen Boyd",         1959);
		this.createAddMovie("The Sound Of Music(���� ���� ����)",   "musical/drama",    "Robert Wise",    "Julie Andrews, Christopher Plummer, Eleanor Parker",  1965);
		this.createAddMovie("2001: A Space Odyssey",   "Adventure/SF","Stanley Kubrick",  "Keir Dullea, Gary Lockwood, William Sylvester",                         1968);

		this.createAddMovie("Speed(���ǵ�)",           "action",        "Jan de Bont(�� ���)",  "Keanu Reeves, Dennis Hopper, Sandra Bullock",  1994);
		this.createAddMovie("Toy Story(���� ���丮)",  "animation",     "John Lasseter",         "Tom Hanks, Tim Allen, Don Rickles",            1995);
		this.createAddMovie("Titanic(Ÿ��Ÿ��)",       "drama/romance", "James Cameron",        "Leonardo DiCaprio, Kate Winslet, Billy Zane",   1997);
		this.createAddMovie("Matrix(��Ʈ����)",         "action/SF",     "Andy Wachowski, Lana Wachowski",   "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss",  1999);

		this.createAddMovie("Artificial Intelligence: A.I.", "adventure/SF","Steven Spielberg",  "Haley Joel Osment, Jude Law, Frances O'Connor",            2001 );
		this.createAddMovie("The Lord of the Rings(������ ����)",  "action/adventure/fantasy",   "Peter Jackson",  "Elijah Wood, Ian McKellen, Orlando Bloom",            2001 );
		this.createAddMovie("Harry Potter and the Sorcerer's Stone(�ظ����Ϳ� �������� ��)",     "adventure/fantasy", "Chris Columbus",    "Daniel Radcliffe, Rupert Grint, Richard Harris",   2001);
		this.createAddMovie("Transformer(Ʈ��������)",            "action/SF",                   "Michael Bay",    "Shia LaBeouf, Megan Fox, Josh Duhamel",               2007);
		this.createAddMovie("Iron Man(���̾� ��)",                "action/adventure/SF",         "Jon Favreau",    "Robert Downey Jr., Gwyneth Paltrow, Terrence Howard", 2008);
		this.createAddMovie("Surrogates(��ΰ���Ʈ)",             "action/thriller/SF",          "Jonathan Mostow ","Bruce Willis, Radha Mitchell, Ving Rhames", 2009);

		this.createAddMovie("Kwanghea(����)",    "drama",      "Changmin Choo",                  "Byounghyoun Lee, Hyojoo Han, Sungryoung Ryu",  2012);
		this.createAddMovie("Gravity(�׷���Ƽ)", "drama",      "Alfonso Cuaron(������ ��Ʒ�)",  "Sandra Bullock, George Clooney, Ed Harris",    2013);
		this.createAddMovie("Frozen(�ܿ�ձ�)",  "animation",  "Chris Buck, Jennifer Lee",       "Kristen Bell, Josh Gad, Idina Menzel",         2013);
		this.createAddMovie("Amazing Spiderman 2(�����¡ �����̴���2)",  "action/adventure/SF", "Marc Webb(��ũ ��)", "Andrew Garfield, Emma Stone, Jamie Foxx, Dane DeHaan. Peter Parker",  2014);
		this.createAddMovie("Roaring Currents(��)",  		  "action/drama", 					"Hanmin Kim", "Minsik Choi, Sungryoung Ryu, JingWoong Jo, Myounggon Kim",  2014);
		this.createAddMovie("The Avengers: Age of Ultron(�����2)",     "action/SF",           "Joss Whedon", "Robert Downey Jr., Chris Evans, Mark Ruffalo",  2015);

	}

	int displayGetMenu(String menuTitle, String[] menus) {
		int cntMenus = menus.length ; 
		int menu = 0;
		
		System.out.println(menuTitle);

		while(true) {			
			for (int i = 1; i <= cntMenus; i++)
				System.out.println("  " + i + ") " + menus[i-1]);

			menu  = this.getIntWithPrompt("����", 1, cntMenus);  // getIntWithPrompt()�� 1���� cntMenus ������ �޴� ������ ����
                                         
			if (menu >=1 && menu <= cntMenus)   // �ùٸ� �޴� ��ȣ�� �ԷµǸ� �� ��ȣ�� ��ȯ
				return menu;
		}
	}

	void doWork(int menu) {
		switch(menu) {
		case 1:
			this.getEnrolMovie();    // ���ο� ��ȭ ��� 
			break;

		case 2:
			this.showAllMovies();    // ��� ��ȭ �˻��Ͽ� ����
			break;

		case 3:
			this.showMovieByTitle(); // �������� �˻��Ͽ� ����
			break;		   		

		case 4:
			this.showMovieByGenre(); // �帣�� �˻��Ͽ� ����
			break;
		case 5:
			this.showMovieByDirector();  // �������� �˻��Ͽ� ���� - �̿ϼ��� �޴� �ϼ���
			break;		   		

		case 6:
			this.showMovieByActors();    // �ֿ����� �˻��Ͽ� ���� - �� �޼ҵ带 �ϼ��Ͻÿ�
			break;

		case 7:
			this.deleteMovie();    // ��ȭ �����Ͽ� ���� - �޴� �߰���
			break;

		}
	}

	// ��ȭ ������ �־����� ��ȭ ��ü�� �����ϰ� �̸� �־��� movies Vector ��ü�� ����
	Movie createAddMovie(String title, String genre, String director, String actors, int yearMade) {  // ��ȯŸ���� Movie�̹Ƿ� Movie ��ü�� ��ȯ��
		Movie m = createMovie(title, genre, director, actors, yearMade);   // ��ȭ ��ü�� ������ ���۷��� ���� m�� ����

		this.addMovie(m);  // m�� ���۷����ϴ� ��ü�� movies Vector ��ü�� ����

		return m;
	}


	// �޴� 1: ��ȭ ������ �Է��Ͽ� ��ȭ ��ü�� �����ϰ� Vector ��ü movies�� ����
	void getEnrolMovie() {	
		this.outputSubtitle("���ο� ��ȭ ����ϱ�");

		Movie m = inputCreateMovie();  // ��ȭ ������ �Է��Ͽ� ��ȭ ��ü�� �����ϰ� ������ ��ü�� ��ȯ����

		this.addMovie(m);  // ������ ��ü�� Vector ��ü movies�� ����

		this.outputResult("  !! ���ο� ��ȭ(" + m + ")�� �����ǰ� Vector ��ü movies�� �����");
	}

	// ��ȭ ������ �Է¹޾� Movie ��ü�� �����ϰ�, ������ ��ü�� ��ȯ
	Movie inputCreateMovie() { // ��ȯŸ���� Movie�̹Ƿ� Movie ��ü�� ��ȯ��

		// Movie Ŭ������ input() �޼ҵ带 �̿��Ͽ� Movie ��ü�� �Էµ� �ʵ� �����ϱ�
		Movie m = new Movie();   // Movie ��ü�� ����
		m.input();                // Movie�� ���� �ʵ带 �Է��Ͽ� ����
		
		return m;
	}

	// setupInitalMovies()���� ��ȭ ������ �־����� ��ȭ ��ü�� �����Ͽ� ��ȯ
	Movie createMovie(String title, String genre, String director, String actors, int yearMade) { // ��ȯŸ���� Movie�̹Ƿ� Movie ��ü�� ��ȯ��

		Movie m = new Movie(title, genre, director, actors, yearMade); // �Էµ� �ʵ� ���� ���� ��ü�� �����Ͽ� m�� ����

		return m;  // m�� ��ȯ
	}


	// newMovie�� ����� Movie ��ü�� Vector ��ü movies�� ó�� ����� ����
	void addMovie(Movie newMovie) {
		movies.add(newMovie);  //newMovie��  Vector ��ü movies�� ���ҷ� �߰�
	}

	// �޴� 2: Vector ��ü movies�� ����� ��� ��ü�� ��� 
	void showAllMovies() {
		this.outputMovies(movies, "��� ��ȭ�� ����", "    !! ���� ��ϵ� ��ȭ�� �ϳ��� �����ϴ�");
	}

	// Vector ��ü movies�� ����� ��ü���� ��� ���
	//   �̶� �־��� subtitle�� ����ϰ�, ����� ��ü�� �ϳ��� ������ �־��� errorMSG�� �����
	void outputMovies(Vector<Movie> movies, String subtitle, String errorMSG) {

		this.outputSubtitle(subtitle);

		if (movies.size() == 0) {
			this.outputResult(errorMSG);
		}
		else {
			this.outputNewLine();

			int cntMovies = movies.size();  // ����� ��ȭ ������ ���Ͽ� cntMovies�� ����
			
			for (int i = 0; i < cntMovies; i++) {
				movies.get(i).output("    " + (i + 1) + "��° ��ȭ");  // i��° ���Ҹ� get()���� ���� ���

				if (i % 10 == 9)
					this.outputNewLine();  // �� 10�ٸ��� �� ���� �ϳ� �����
			}
		}
	}

	// �޴� 3: �ʵ��� Vector ��ü movies�� ��ȭ �߿��� �Էµ� ������ ��ȭ�� �˻��Ͽ� ����ϱ�
	void showMovieByTitle() {
		this.outputSubtitle("�Էµ� ������ �����ϴ� ��ȭ�� �˻��Ͽ� ���");

		if (movies.size() == 0) {
			this.outputResult("  !! ��ȭ�� �ϳ��� �����Ƿ� �˻��� �� �����ϴ�.");
		}
		else { 
			String titleToSearch = getStringWithPrompt("�˻��� ����");

			Vector<Movie> moviesSearched = searchMovieByTitle(titleToSearch);

			this.outputMovies(moviesSearched, "��ü ��ȭ �� ���� '" + titleToSearch + "'��(��) ������ ��ȭ��", 
					"  !!  ���� '" + titleToSearch + "'��(��) ������ ��ȭ�� �ϳ��� �����ϴ�");
		}
	}

	// �ʵ��� Vector ��ü movies�� ��ȭ �߿��� ������ titleToSearch�� �����ϴ� ��ȭ�� ã�� �̵� ��θ� Vector ��ü�� �����Ͽ� ��ȯ
	Vector<Movie>  searchMovieByTitle(String titleToSearch) {
		int noMovies = movies.size();  // movies Vector ��ü�� ���� ������ ����

		Vector<Movie> moviesSearched = new Vector<Movie>();   // Vector �������� moviesSearched �����Ͽ� Vector ��ü ���� ����

		for (int cnt = 0; cnt < noMovies; cnt++) {    //  Vector ��ü �ʵ� movies�� ����� ��� ��ȭ�� ����
			Movie m = movies.get(cnt);                //  cnt ��ġ��  ��ȭ�� m�� �����Ͽ�
		
			if (movies.get(cnt).title.toLowerCase().contains(titleToSearch.toLowerCase()))   // ��ȭ ������ �Էµ� ������ �����ϸ�(��� �ҹ��ڷ� �����Ͽ� ���Ե� ���� ����)
				moviesSearched.add(m);                // �� ��ȭ ��ü�� Vector ��ü moviesSearched�� ����
		}
		
		return moviesSearched; //  Vector ��ü  moviesSearched�� ��ȯ
	}


	// �޴� 4: �ʵ��� Vector ��ü movies�� ��ȭ �߿��� �Էµ� �帣�� ��ȭ�� �˻��Ͽ� ����ϱ�
	void showMovieByGenre() {
		this.outputSubtitle("�Էµ� �帣�� ��ȭ�� �˻��Ͽ� ���");

		if (movies.size() == 0) {
			this.outputResult("  !! ��ȭ�� �ϳ��� �����Ƿ� �˻��� �� �����ϴ�.");
		}
		else { 
			String genreToSearch  = getStringWithPrompt("�˻��� �帣");

			Vector<Movie> moviesSearched = searchMovieByGenre(genreToSearch);

			this.outputMovies(moviesSearched, "��ü ��ȭ �� '" + genreToSearch + "' �帣�� ��ȭ��", 
					"  !! '" + genreToSearch + "' �帣�� ��ȭ�� �ϳ��� �����ϴ�");
		}
	}		

	// �ʵ��� Vector ��ü  movies�� ��ȭ �߿��� �帣�� genreToSearch�� �����ϴ� ��ȭ�� ã�� �̵� ��θ� Vector ��ü�� �����Ͽ�  ��ȯ
	Vector<Movie> searchMovieByGenre(String genreToSearch) {
		int noMovies = movies.size();  // movies Vector ��ü�� ���� ������ ����

		Vector<Movie> moviesSearched = new Vector<Movie>();  // Vector �������� moviesSearched �����Ͽ� Vector ��ü ���� 

		for (int cnt = 0; cnt < noMovies; cnt++) {     //  Vector ��ü �ʵ� movies�� ����� ��� ��ȭ�� ����
			Movie m = movies.get(cnt);                 //  cnt ��ġ��  ��ȭ�� m�� �����Ͽ�
			
		    if (m.genre.toLowerCase().contains(genreToSearch.toLowerCase()))   // ��ȭ �帣�� �Էµ� �帣�� �����ϸ�(��� �ҹ��ڷ� �����Ͽ� ���Ե� ���� ����)
				moviesSearched.add(m);                 // �� ��ȭ ��ü�� Vector ��ü moviesSearched�� ����
		}
		
		return moviesSearched; // Vector ��ü moviesSearched�� ��ȯ
	}


	// �޴� 5: �ʵ��� Vector ��ü movies�� ��ȭ �߿��� �Էµ� ������ ��ȭ�� �˻��Ͽ� ����ϱ�
	void showMovieByDirector() {
		this.outputSubtitle("�Էµ� ������ �����ϴ� ��ȭ�� �˻��Ͽ� ���");

		if (movies.size() == 0) {
			this.outputResult("  !! ��ȭ�� �ϳ��� �����Ƿ� �˻��� �� �����ϴ�.");
		}
		else { 
			String directorToSearch  = getStringWithPrompt("�˻��� ��ȭ�� ����");

			Vector<Movie> moviesSearched = searchMovieByDirector(directorToSearch);

			this.outputMovies(moviesSearched, "��ü ��ȭ �� ������ '" + directorToSearch + "'��(��) ������ ��ȭ��", 
					"  !!  ���� '" + directorToSearch + "'��(��) ������ ��ȭ�� �ϳ��� �����ϴ�");
		}
	}

	// �ʵ��� Vector ��ü  movies�� ��ȭ �߿��� ������ directorToSearch�� �����ϴ� ��ȭ�� ã�� �̵� ��θ� ��ȯ
	Vector<Movie> searchMovieByDirector(String directorToSearch) {
		int noMovies = movies.size();  // movies Vector ��ü�� ���� ������ ����

		Vector<Movie> moviesSearched = new Vector<Movie>();  // Vector ��ü ��������  moviesSearched�� ����� Vector ��ü ����

		int cntSearched = 0;  // Ž�������� ��ȭ ��ü�� ������ �����ϴ� ����

		for (int cnt = 0; cnt < noMovies; cnt++) {  // movies�� ����� ��� ��ȭ�� ����
			Movie m =  movies.get(cnt);
			if (m.director.toLowerCase().contains(directorToSearch.toLowerCase()))   // ��ȭ �帣�� �Էµ� �帣�� �����ϸ�(��� �ҹ��ڷ� �����Ͽ� ���Ե� ���� ����)
				moviesSearched.add(m);                             // �� ��ȭ ��ü�� Vector ��ü moviesSearched�� ����
		}
		
		return moviesSearched; // moviesSearched Vector ��ü�� ��ȯ
	}

	// �޴� 6: �ʵ��� Vector ��ü  movies�� ��ȭ �߿��� �Էµ� ����� ��ȭ�� �˻��Ͽ� ����ϱ�
	void showMovieByActors() {
		System.out.println("\n\n  !!!! Not implented yet !!!!");
		// �ۼ��Ͻÿ�
	}

	// �޴� 7: �ʵ��� ��ü �迭 movies[]�� ��ȭ �߿��� ���õ� ��ȭ�� �����ϱ�
	void deleteMovie() {
		this.outputMovies(movies, "���� ������  ��� ��ȭ��", "    !! ���� ��ϵ� ��ȭ�� �ϳ��� �����Ƿ� ������ �� �����ϴ�");
		
		if (movies.size() > 0) {
			int no = getIntWithPrompt("������ ��ȭ�� ��ȣ", 1, movies.size());

			Movie m = deleteMovie(no - 1);  // no - 1��ġ(0���� ����)�� ��ȭ �����ϴ� �޼ҵ� ȣ��
			this.outputResult("  !! " + no + "��° ��ȭ '" + m.title + "'�� �����Ǿ����ϴ�.");
		}
	}
	// �Ű����� n�� �־��� ��ġ(��ġ�� 0���� ������)�� ��ȭ�� movies[] �迭���� ����
	Movie deleteMovie(int n) {		
		Movie m = movies.get(n);  // ������ ��ȭ�� m�� ����
		
		// Vector ��ü���� Ư�� ��ġ�� ���Ҹ� �����ϴ� ���� remove(int index) �޼ҵ�� ������
		movies.remove(n);  // index n�� ��ġ�� ��ʼ� ����
		
		return m;  // ������ ��ȭ�� ��ȯ
	}

	/*
	 * ������ �޼ҵ���� ���� ������� ���� ���� ��� Ŭ�������� ���Ǵ� �޼ҵ����
	 * 
	 */

	// ���α׷��� ��ü Ÿ��Ʋ�� ���(���� 3���� �ٿ� �� Ÿ��Ʋ ��� �� 2���� �ٿ�)
	void outputTitle(String title) {
		System.out.println("\n\n\n  **** " + title + " ****\n");
	}

	// ���α׷��� ��Ÿ��Ʋ�� ���(���� 2���� �ٿ� �� ��Ÿ��Ʋ ��� �� 1���� �ٿ�)
	void outputSubtitle(String subtitle) {
		System.out.println("\n\n  ** " + subtitle + " **");
	}

	// ���α׷� ���� �޼����� ���
	void outputEnding(String ending) {
		System.out.println("\n\n  !!!! " + ending + " Bye!!!!");
	}


	// �ٹٲ��� �Ͽ� ���ο� �ٿ��� ����� �ǰ� �� - �� �޼ҵ带 ȣ���� ������ ��� ��¿� ���ؼ��� �����ϸ��
	void outputNewLine() {
		System.out.println();
	}

	// �ٹٲ��� �� �� �־��� ��� ���ڿ��� ��� - �� �޼ҵ带 ȣ���� ������ ��� ��¿� ���ؼ��� �����ϸ��
	void outputResult(String rst) {
		System.out.println("\n" + rst);
	}

	// ������Ʈ �޼����� ����� �� ���� �ٿ��� �������� �о� ��ȯ
	int getIntWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getInt();		
	}

	// ������Ʈ �޼����� ����� �� min���� max ������ �������� �о� ��ȯ
	int getIntWithPrompt(String prompt, int min, int max) {
		int n;

		do  {
			System.out.print("\n  o " + prompt + "(" + min + "���� " + max + "����) > ");

			n = SkScanner.getInt();	
		} while (n < min || n > max);

		return 	n;
	}
	// ������Ʈ �޼����� ����� �� �Ǽ����� �о� ��ȯ
	double getDoubleWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getDouble();		
	}

	// ������Ʈ �޼����� ����� �� ���ڿ��� �о� ��ȯ
	String getStringWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getString();		
	}
}

/* 
 *  [ �ǽ� ���� ]
 *  
 *    1. �̿ϼ� �κ��� void showMovieByDirector()��   void showMovieByActors()�� �ϼ��϶�.    
 *        
 *    2. ��ü ��ȭ �߿��� ��ȭ�� �ϳ� �����Ͽ� �����ϴ� �޴� "��ȭ ����"�� 7�� �޴��� �߰��ϵ��� ���α׷��� �����Ϸ��Ѵ�.
 *       ���ο� �޴��� �߰��Ǹ� ���� �޴��� 8���� �ȴ�.
 *       
 *       ��ü ��ȭ�� ������ �� ������ ��ȭ�� ��ȣ�� �Է¹��� �� �ش� ��ȭ�� �����ϴ� removeMovie() �޼ҵ带 �ۼ��϶�. 
 *       
 *       Vector ��ü���� ��ġ index�� ���Ҹ� �����ϱ� ���ؼ���  void remove(int index) �޼ҵ带 ����Ѵ�.  
 *       ���� ���, Vector ��ü  movies���� 0 ��ġ�� ���Ҹ� �����ϴ� �ڵ�� << movies.remove(0); >>�̴�.
 */
