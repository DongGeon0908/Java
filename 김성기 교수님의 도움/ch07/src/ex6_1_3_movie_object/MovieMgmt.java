package ex6_1_3_movie_object;

/**
 * [ Movie, MovieMgmt ]:  ��ü �ʵ� �� �޼ҵ�, ��ü �迭�� ����
 *  
 *   o ��ü �迭
 *      - ���� �迭�� ���� ������ �����ϵ��� ��ü �迭�� ���� ��ü���� �����ϴ� �迭
 *      
 *      - ��ü�� �����Ǹ� ���������� ����Ǿ� ��ü�� �ʵ峪 �޼ҵ带 �����ϰ� ��
 *      - �׷��� �� Ŭ������ ���� ��ü�� �����Ǹ� �̵��� ��ü������ ������ �ʿ䰡 ������
 *        �̸� ���� �⺻���� ����� ������ ��ü���� ��ü �迭�� ���ҷ� �����ϴ� ��
 *       
 *      - ��ü �迭�� ����: Ŭ�����̸�[] �迭�����̸� = new Ŭ�����̸�[���Ұ���];
 *
 *   o ����, �帣, ����, �ֿ����, ���۳⵵ ���� �ʵ带 ���� Movie Ŭ������ �̿��� ��ü ����
 *   
 *     - �� Ŭ���������� ��ü���� �� ��ü �迭�� ����, ��� ��ü ����, ��ȭ����, �帣, ����, �ֿ���� ���� ��ȭ�� �˻�
 *       ���� �۾��� ����
 *         
 *     - �˻��� ���ڿ��� �񱳷� �̷����
 *     
 *     - String Ÿ���� �� ���ϴ� �߿� ������
 *         1) ���ڿ�1.equals(���ڿ�2): ���ڿ�1�� ���ڿ�2�� ������ true��, �ٸ��� false�� ��ȯ
 *              "Speed".equals("Speed") ==> true�� ��ȯ,  "Speed".equals("Speedo") ==> false�� ��ȯ
 *              
 *         2) ���ڿ�1.contains(���ڿ�2): ���ڿ�1�� ���ڿ�2�� �����ϸ� true��, �������� ������ false�� ��ȯ
 *              "The Sound of Music".equals("Music") ==> true ��ȯ,  "The Sound of Music".equals("music") ==> false ��ȯ 
 *        
 *     - ���ڿ� �񱳿��� ���ҹ��ڿ� ���빮�ڴ� ���� �ٸ� ����
 *       ��ҹ��ڸ� �����ϸ鼭 equals() �Ǵ� contains()�� �̿��Ͽ� ���Ϸ��� 
 *       ���ڿ��� ��� �빮�� �Ǵ� �ҹ��ڷ� ��ȯ�ϸ� ����
 *       
 *     - ��ҹ��� ��ȯ�� ���� �����Ǵ� �޼ҵ�
 *         1) ���ڿ�.toLowerCase():  ���ڿ��� ���Ե� �빮�ڸ� ��� �ҹ��ڷ� ������ ���ڿ��� ��ȯ
 *                "The Sound of Music".toLowerCase() ==> "the sound of music" ��ȯ 
 *                 
 *        2) ���ڿ�.toUpperCase():  ���ڿ��� ���Ե� �ҹ��ڸ� ��� �빮�ڷ� ������ ���ڿ��� ��ȯ
 *                "The Sound of Music".toUpperCase() ==> "THE SOUND OF MUSIC" ��ȯ 
 *                
 *         �׷��Ƿ� "The Sound of Music".toLowerCase().contains("music")  ==> true�� ��ȯ
 *     
 *   o �� ���α׷����� main()�� ������  ��� �޼ҵ�� ��ü �޼ҵ�� �ۼ�
 *     - ��ü �޼ҵ�� ��ü ������ �� ��ü�� �����ڷ� ȣ�� 
 *     
 *     - ����, ������ Ŭ������ �ٸ� �޼ҵ带 ȣ���� �� �����ڰ� this           
 */

class Movie {

	String  title, genre, director, actors;  // ����, �帣, ����, �ֿ����� 
	int yearMade;                            // ���۳⵵

	Movie() {  // �ٸ� ��ü �����ڸ� �ۼ��� ��� �Ű����� ���� ��ü �����ڸ� �ۼ��ϴ� ���� ����
	}

	// ����, �帣, ����, �ֿ�����, ���۳⵵�� �־����� ��ȭ ��ü �����ϴ� ��ü ������
	Movie(String  title, String  genre, String director, String actors, int yearMade) {
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
	void input(String title) {
		System.out.println(title);  // �Է��� ���� Ÿ��Ʋ ���
		input();                    // �ʵ带 �Է�
	}

	// ��ü�� �ʵ� ������ ���ڿ��� ����� ��ȯ�ϴ� �޼ҵ�.
	public String toString() {
		return "����: '" + this.title + "',  �帣: '" + this.genre 
				+ "',  ����: '" + director  + "',  �ֿ�����: '" + actors + "', ���ۿ���: " + yearMade;
	}

	// ��ü�� �ʵ� ���� ����ϱ� ���� �޼ҵ�
	//   toString() �޼ҵ带 �̿��Ͽ� ó��
	void output(String message) {
		System.out.println("  " + message + " - " + this.toString());
		// ���� ������ ������ ������ ������ ������
		// System.out.println("  " + message + " - " + toString());  // < this. >�� �����Ǿ ��
		// System.out.println("  " + message + " - " + this);  // println() �޼ҵ忡�� ��ü ���� ����� toString() �޼ҵ带 �ڵ������� ȣ���Ͽ� ���

	}
}

class MovieMgmt  {
	// Movie ��ü 200���� ������ �� �ִ� �迭 ���� movies ���� �� �迭 ��ü ����
	Movie movies[] = new Movie[200];  // �迭 ������ �ݵ�� < Ÿ�Ը� �迭���� = new Ÿ�Ը�[���Ұ���] >�� �迭 ��ü ���� �� �����ؾ� ��!!!!!

	public static void main(String[] args) {
		MovieMgmt mms = new MovieMgmt();

		mms.setupInitialMovies();  // �־��� ��ȭ ������� ���� ��ȭ ��ü���� ���� �� movies[] ��ü �迭�� ����

		int menu = 0;

		while(menu != 7) {
			menu = mms.displayGetMenu();

			if (menu==7)  {  // ���� ���� ��
				mms.outputResult("  !! ��ȭ ������ �����մϴ�. Bye!!!");     // ���� �޽��� ��� ��
				break;                                          // while ���� ��� ������(< return menu; >�� �̿��Ͽ��� ���� ȿ����)
			}	

			mms.doWork(menu);
		}
	}

	// �־��� �ʱ� ��ȭ������ ��ȭ ��ü �����Ͽ� movies[] ��ü �迭�� �����ϴ� �޼ҵ�
	//  �� �޼ҵ�� �޴��� ����Ǳ� ���� ȣ���
	void setupInitialMovies() {
		this.createAddMovie("Ben Her, Ben-Her(����)",                 "adventure/drama",  "William Wyler",  "Charlton Heston, Jack Hawkins, Stephen Boyd",         1959);
		this.createAddMovie("The Sound Of Music(���� ���� ����)",   "musical/drama",    "Robert Wise",    "Julie Andrews, Christopher Plummer, Eleanor Parker",  1965);
		this.createAddMovie("2001: A Space Odyssey",   "Adventure/SF","Stanley Kubrick",  "Keir Dullea, Gary Lockwood, William Sylvester",                         1968);

		this.createAddMovie("Speed(���ǵ�)",           "action",        "Jan de Bont(�� ���)",  "Keanu Reeves, Dennis Hopper, Sandra Bullock",  1994);
		this.createAddMovie("Toy Story(���� ���丮)",  "animation",     "John Lasseter",         "Tom Hanks, Tim Allen, Don Rickles",            1995);
		this.createAddMovie("Titanic(Ÿ��Ÿ��)",       "drama/romance", "James Cameron",        "Leonardo DiCaprio, Kate Winslet, Billy Zane",   1997);
		this.createAddMovie("Matrix(��Ʈ����",         "action/SF",     "Andy Wachowski, Lana Wachowski",   "Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss",  1999);

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

	int displayGetMenu() {
		int menu;

		while(true) {			// ���ᰡ ���õ� ������ �ݺ� ����
			System.out.println("\n\n       **** ��ȭ ���� �ý��� ****\n");
			System.out.println("  1) ���ο� ��ȭ ���               2) ��� ��ȭ �˻�");
			System.out.println("  3) �������� ��ȭ �˻�            4) �帣�� ��ȭ �˻�");
			System.out.println("  5) ���� �̸����� ��ȭ �˻�      6) �ֿ���� �̸����� ��ȭ �˻�");
			System.out.println("  7) ����");

			menu  = this.getIntWithPrompt("����", 1, 7);  // getIntWithPrompt()�� 1���� 7 ���� �޴� ������ ����

			if (menu >=1 && menu <= 7)   // �ùٸ� �޴� ��ȣ�� �ԷµǸ� �� ��ȣ�� ��ȯ
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
			this.showMovieByDirector();  // �������� �˻��Ͽ� ���� - �� �޼ҵ带 �ϼ��Ͻÿ�
			break;		   		

		case 6:
			this.showMovieByActors();    // �ֿ����� �˻��Ͽ� ���� - �� �޼ҵ带 �ϼ��Ͻÿ�
			break;
		}
	}

	// ��ȭ ������ �־����� ��ȭ ��ü �����ϰ� �̸� �־��� movies[] ��ü �迭�� ����
	Movie createAddMovie(String title, String genre, String director, String actors, int yearMade) {  // ��ȯŸ���� Movie�̹Ƿ� Movie ��ü�� ��ȯ��
		Movie m = createMovie(title, genre, director, actors, yearMade);   // ��ȭ ��ü �����Ͽ� ��ü �������� m�� ����

		this.addMovie(m);  // m�� �����ϴ� ��ü�� movies[] ��ü �迭�� ����

		return m;
	}

	// �޴� 1: ��ȭ ������ �Է��Ͽ� ��ȭ ��ü �����ϰ� ��ü �迭 movies[]�� ����
	void getEnrolMovie() {	
		this.outputSubtitle("���ο� ��ȭ ����ϱ�");

		Movie m = inputCreateMovie();  // ��ȭ ������ �Է��Ͽ� ��ȭ ��ü �����ϰ� ������ ��ü�� ��ȯ����

		this.addMovie(m);  // ������ ��ü�� ��ü �迭 movies[]�� ����

		this.outputResult("  !! ���ο� ��ȭ(" + m + ")�� �����ǰ� ��ü �迭 movies[]�� �����");
	}

	// ��ȭ ������ �Է¹޾� Movie ��ü �����ϰ�, ������ ��ü�� ��ȯ
	Movie inputCreateMovie() { // ��ȯŸ���� Movie�̹Ƿ� Movie ��ü�� ��ȯ��

		// Movie Ŭ������ input() �޼ҵ带 �̿��Ͽ� Movie ��ü�� �Էµ� �ʵ� �����ϱ�
		Movie m = new Movie();   // Movie ��ü ����
		m.input();                // Movie�� ���� �ʵ带 �Է��Ͽ� ����
		
		return m;
		
//      ***** createMovie() �޼ҵ带 �̿��ϱ� ���� �ڵ� ****	
//		
//		String title = getStringWithPrompt("��ȭ����");
//		String genre  = getStringWithPrompt("�帣");
//		String director  = getStringWithPrompt("����");
//		String actors  = getStringWithPrompt("�ֿ�����");
//		int yearMade = getIntWithPrompt("���۳⵵");
//
//		return this.createMovie(title, genre, director, actors, yearMade);
	}

	// setupInitialMovies()���� ��ȭ ������ �־����� ��ȭ ��ü �����Ͽ� ��ȯ
	Movie createMovie(String title, String genre, String director, String actors, int yearMade) { // ��ȯŸ���� Movie�̹Ƿ� Movie ��ü�� ��ȯ��

		Movie m = new Movie(title, genre, director, actors, yearMade); // �Էµ� �ʵ� ���� ���� ��ü �����Ͽ� m�� ����

		return m;  // m�� ��ȯ
	}

	// newMovie�� ����� Movie ��ü�� ��ü �迭 movies[]�� ó�� ����� ����
	void addMovie(Movie newMovie) {
		int i;		
		for (i = 0; movies[i] != null; i++) ;  // movies ��ü �迭���� ���ο� Movie ��ü�� ������,  �� ������ ó�� ��ġ�� ã��
		// Movie ��ü�� ���� �ȵ� ������ ���� null��

		movies[i] = newMovie;  // �� ������ ó�� ��ġ�� ���ҷ� ��ü�� ����
	}

	// �޴� 2: ��ü �迭 movies[]�� ����� ��� ��ü�� ��� 
	void showAllMovies() {
		this.outputMovies(movies, "��� ��ȭ�� ����", "    !! ���� ��ϵ� ��ȭ�� �ϳ��� �����ϴ�");
	}

	// ��ü �迭 movies[]�� ����� ��ü���� ��� ���
	//   �̶� �־��� subtitle ����ϰ�, ����� ��ü�� �ϳ��� ������ �־��� errorMSG�� �����
	void outputMovies(Movie movies[], String subtitle, String errorMSG) {

		this.outputSubtitle(subtitle);

		if (movies[0] == null) {
			this.outputResult(errorMSG);
		}
		else {
			this.outputNewLine();

			for (int i = 0; movies[i] != null; i++) {
				movies[i].output("    " + (i + 1) + "��° ��ȭ"); 

				if (i % 10 == 9)
					this.outputNewLine();  // �� 10�ٸ��� �� ���� �ϳ� �����
			}
		}
	}

	// �޴� 3: �ʵ��� ��ü �迭 movies[]�� ��ȭ �߿��� �Էµ� ������ ��ȭ�� �˻��Ͽ� ����ϱ�
	void showMovieByTitle() {
		this.outputSubtitle("�Էµ� ������ �����ϴ� ��ȭ�� �˻��Ͽ� ���");

		if (movies[0] == null) {
			this.outputResult("  !! ��ȭ�� �ϳ��� �����Ƿ� �˻��� �� �����ϴ�.");
		}
		else { 
			String titleToSearch  = getStringWithPrompt("�˻��� ����");

			Movie[] moviesSearched = searchMovieByTitle(titleToSearch);

			this.outputMovies(moviesSearched, "��ü ��ȭ �� ���� '" + titleToSearch + "'��(��) ������ ��ȭ��", 
					"  !!  ���� '" + titleToSearch + "'��(��) ������ ��ȭ�� �ϳ��� �����ϴ�");
		}
	}

	// �ʵ��� ��ü �迭 movies[]�� ��ȭ �߿��� ������ titleToSearch�� �����ϴ� ��ȭ�� ã�� �̵� ��θ� ��ȯ
	Movie[] searchMovieByTitle(String titleToSearch) {
		int noMovies = movies.length;  // movies[] �迭 ��ü�� ���� ������ ����

		Movie moviesSearched[] = new Movie[noMovies];   // moviesSearched[] �迭�� ����� �迭 ��ü ����(���� ������ movies[] �迭 ��ü�� ���� ������ ����)

		int cntSearched = 0;   // Ž�������� ��ȭ ��ü�� ������ �����ϴ� ����

		for (int cnt = 0; cnt < noMovies && movies[cnt] != null; cnt++)   // movies[]�� ����� ��� ��ȭ�� ����(movies[cnt] != null�̾�� ���� Movie ��ü�� ����� ����)
			if (movies[cnt].title.toLowerCase().contains(titleToSearch.toLowerCase()))   // ��ȭ ������ �Էµ� ������ �����ϸ�(��� �ҹ��ڷ� �����Ͽ� ���Ե� ���� ����)
				moviesSearched[cntSearched++] = movies[cnt];                             // �� ��ȭ ��ü�� moviesSearched[] �迭��ü�� �����ϰ� cntSearched 1����

		return moviesSearched; // moviesSearched[] �迭 ��ü�� ��ȯ
	}

	// �޴� 4: �ʵ��� ��ü �迭 movies[]�� ��ȭ �߿��� �Էµ� �帣�� ��ȭ�� �˻��Ͽ� ����ϱ�
	void showMovieByGenre() {
		this.outputSubtitle("�Էµ� �帣�� ��ȭ�� �˻��Ͽ� ���");

		if (movies[0] == null) {
			this.outputResult("  !! ��ȭ�� �ϳ��� �����Ƿ� �˻��� �� �����ϴ�.");
		}
		else { 
			String genreToSearch  = getStringWithPrompt("�˻��� �帣");

			Movie[] moviesSearched = searchMovieByGenre(genreToSearch);

			this.outputMovies(moviesSearched, "��ü ��ȭ �� '" + genreToSearch + "' �帣�� ��ȭ��", 
					"  !! '" + genreToSearch + "' �帣�� ��ȭ�� �ϳ��� �����ϴ�");
		}
	}		

	// �ʵ��� ��ü �迭 movies[]�� ��ȭ �߿��� �帣�� genreToSearch�� �����ϴ� ��ȭ�� ã�� �̵� ��θ� ��ȯ
	Movie[] searchMovieByGenre(String genreToSearch) {
		int noMovies = movies.length;  // movies[] �迭 ��ü�� ���� ������ ����

		Movie moviesSearched[] = new Movie[noMovies];  // moviesSearched[] �迭�� ����� �迭 ��ü ����(���� ������ movies[] �迭 ��ü�� ���� ������ ����)

		int cntSearched = 0;  // Ž�������� ��ȭ ��ü�� ������ �����ϴ� ����

		for (int cnt = 0; cnt < noMovies && movies[cnt] != null; cnt++)   // movies[]�� ����� ��� ��ȭ�� ����(movies[cnt] != null�̾�� ���� Movie ��ü�� ����� ����)
			if (movies[cnt].genre.toLowerCase().contains(genreToSearch.toLowerCase()))   // ��ȭ �帣�� �Էµ� �帣�� �����ϸ�(��� �ҹ��ڷ� �����Ͽ� ���Ե� ���� ����)
				moviesSearched[cntSearched++] = movies[cnt];                             // �� ��ȭ ��ü�� moviesSearched[] �迭��ü�� �����ϰ� cntSearched 1����

		return moviesSearched; // moviesSearched[] �迭 ��ü�� ��ȯ
	}

	// �޴� 5: �ʵ��� ��ü �迭 movies[]�� ��ȭ �߿��� �Էµ� ������ ��ȭ�� �˻��Ͽ� ����ϱ�
	void showMovieByDirector() {
		System.out.println("\n\n  !!!! Not implemented yet !!!!");
		// �ۼ��Ͻÿ�
	}

	// �޴� 6: �ʵ��� ��ü �迭 movies[]�� ��ȭ �߿��� �Էµ� ����� ��ȭ�� �˻��Ͽ� ����ϱ�
	void showMovieByActors() {
		System.out.println("\n\n  !!!! Not implemented yet !!!!");
		// �ۼ��Ͻÿ�
	}

	/*
	 * ������ �޼ҵ���� ���� ������� ���� ���� ��� Ŭ�������� ���Ǵ� �޼ҵ����
	 * 
	 *   ������ class MovieArray�� �޼ҵ�� �ۼ������� ���߿��� SkScanner Ŭ���� �Ǵ� SkOutput Ŭ������ �޼ҵ��
	 *   �ۼ��� ����
	 */

	// ���α׷��� ��ü Ÿ��Ʋ ���(���� 3���� ��� �� Ÿ��Ʋ ��� �� 2���� ���)
	void outputTitle(String title) {
		System.out.println("\n\n\n  **** " + title + " ****\n");
	}

	// ���α׷��� ��Ÿ��Ʋ ���(���� 2���� ��� �� ��Ÿ��Ʋ ��� �� 1���� ���)
	void outputSubtitle(String subtitle) {
		System.out.println("\n\n  ** " + subtitle + " **");
	}

	// ���α׷� ���� �޽����� ���
	void outputEnding(String ending) {
		System.out.println("\n\n  !!!! " + ending + " Bye!!!!");
	}


	// �ٹٲ��� �Ͽ� ���ο� �ٿ��� ����� �ǰ� ��
	void outputNewLine() {
		System.out.println();
	}

	// �ٹٲ��� �� �� �־��� ��� ���ڿ� ���
	void outputResult(String rst) {
		System.out.println("\n" + rst);
	}

	// ������Ʈ �޽����� ����� �� ���� �ٿ��� �������� �о� ��ȯ
	int getIntWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getInt();		
	}

	// ������Ʈ �޽����� ����� �� min���� max ������ �������� �о� ��ȯ
	int getIntWithPrompt(String prompt, int min, int max) {
		int n;

		do  {
			System.out.print("\n  o " + prompt + "(" + min + "���� " + max + "����) > ");

			n = SkScanner.getInt();	
		} while (n < min || n > max);

		return 	n;
	}
	
	// ������Ʈ �޽����� ����� �� �Ǽ����� �о� ��ȯ
	double getDoubleWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getDouble();		
	}

	// ������Ʈ �޽����� ����� �� ���ڿ��� �о� ��ȯ
	String getStringWithPrompt(String prompt) {
		System.out.print("\n  * " + prompt + " > ");

		return SkScanner.getString();		
	}
}

/* 
 *  [ �ǽ� ���� ]
 *  
 *     1. �̿ϼ� �κ��� void showMovieByDirector(Movie movies[])�� 
 *        void showMovieByActors(Movie movies[])�� �ϼ��϶�.    
 */
