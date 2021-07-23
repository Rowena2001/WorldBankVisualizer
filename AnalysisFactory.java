
/**
 * Employs simplified Factory design pattern to generate supported AnalysisType objects, mainly using the analysis titles
 * @author Group 15
 *
 */

public class AnalysisFactory {
	/**
	 * array containing all the titles of the supported analysis types
	 */
	private String[] titles;
	/**
	 * array containing all the World Bank indicators of the supported analysis types
	 */
	private String [][] indicators;
	
	/**
	 * Constructor which initializes the titles and indicators
	 */
	public AnalysisFactory() {
		titles = new String[] {A1.getTitle(), A2.getTitle(), A3.getTitle(), A4.getTitle(), A5.getTitle(), A6.getTitle(), A7.getTitle(), A8.getTitle()};
		indicators = new String[][] {A1.getIndicators(), A2.getIndicators(), A3.getIndicators(), A4.getIndicators(), A5.getIndicators(), A6.getIndicators(), A7.getIndicators(), A8.getIndicators()};
	}
	
	/**
	 * Creates and returns analysistype object created using the given parameters
	 * @param title used to match the analysis type and output the correct object type
	 * @param country
	 * @param startYear
	 * @param endYear
	 * @return
	 */
	public AnalysisType createAnalysis(String title, String country, int startYear, int endYear) {
		int index = getIndex(title);
		switch (index) {
			case 0:
				return new A1(country, startYear, endYear);

			case 1:
				return new A2(country, startYear, endYear);
																																							
			case 2:
				return new A3(country, startYear, endYear);

			case 3:
				return new A4(country, startYear, endYear);

			case 4:
				return new A5(country, startYear, endYear);

			case 5:
				return new A6(country, startYear, endYear);

			case 6:
				return new A7(country, startYear, endYear);

			case 7:
				return new A8(country, startYear, endYear);
		}
		return null;
	}
	/**
	 * 
	 * @return String[][] indicators
	 */
	public String[][] getIndicators(){
		return indicators;
	}
	/**
	 * 
	 * @return String[] titles
	 */
	public String[] getTitles() {
		return titles;
	}
	/**
	 * 
	 * @param title
	 * @return the proper indicator according to the supplied title
	 */
	public String[] getIndicators (String title) {
		int index = getIndex(title);
		return getIndicators()[index];
	}
	
	/**
	 * 
	 * @param title
	 * @return the index of the analysis type within the arrays
	 */
	private int getIndex (String title) {
		int index = -1;
		for (int i = 0; i < titles.length; i++) {
			if (title.equalsIgnoreCase(titles[i])) {
				index = i;
				break;
			}
		}
		return index;
	}
}
