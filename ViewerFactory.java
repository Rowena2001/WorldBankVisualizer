/**
 * Class that creates the viewer object based on user selections
 * @author Group 15
 *
 */
public class ViewerFactory {
	
	private  String[] viewerNames;
	
	/**
	 * Initializes a viewer factory by setting the viewernames
	 */
	public ViewerFactory() {
		viewerNames = new String[] {"bar", "line", "scatter", "report", "pie"};
	}
	
	/**
	 * Creates a Viewer object based on the name of the viewer and other parameters
	 * @param name : the name of the viewer, works as long as it contains the name of the viewer (eg. bar graph and bar work)
	 * @param a	: the AnalysisType object that has all the necessary data to construct the viewer
	 * @param startYear : the start year for labelling
	 * @param endYear : the end year for labeling
	 * @param country : the country for the title
	 * @return Viewer object that has not yet had buildGraph called
	 */
	public Viewers createViewer(String name, AnalysisType a, int startYear, int endYear, String country) {
		//creates the title of the viewer by concatinating the analysis title and the country
		String fullTitle = country.concat(": ").concat(a.getInstTitle());

		//if the viewer name relates to bar graphs
		if (name.toLowerCase().contains(viewerNames[0])) {
			Data[] d = a.calculate();
			String[] u = a.getUnits();
			return new BarChart(fullTitle, d, startYear, endYear, "Years", convertUnits(d, u), getSeriesLabels(d, a.getInstTitle()));
		}
		//if the viewer name relates to line graphs
		else if (name.toLowerCase().contains(viewerNames[1])) {
			Data[] d = a.calculate();
			String[] u = a.getUnits();
			
			return new LineChart(fullTitle, d, startYear, endYear, "Years", convertUnits(d, u), getSeriesLabels(d, a.getInstTitle()));
		}
		//if the viewer name relates to scatter plots
		else if (name.toLowerCase().contains(viewerNames[2])) {
			Data[] d = a.calculate();
			String[] u = a.getUnits();
			
			return new ScatterChart(fullTitle, d, startYear, endYear, "Years", convertUnits(d, u), getSeriesLabels(d, a.getInstTitle()));
		}
		//if the viewer name relates to reports
		else if (name.toLowerCase().contains(viewerNames[3])) {
			return new Report(fullTitle, a.calculate(), startYear, endYear, a.getUnits());
		}
		//if the viewer name relates to pie charts
		else if (name.toLowerCase().contains(viewerNames[4])) {
			return new PieChart(fullTitle, a.calculate(), startYear, endYear);
		}
		//otherwise, it will return a null object
		else {
			return null;
		}
	}
	/**
	 * Creates the series labels used by some graphs to create legends
	 * @param d : the dataset, used to determine how to group the labels
	 * @param title	: the analysis title 
	 * @return String[][] which contains the labels appropriate for creating legends
	 */
	private String[][] getSeriesLabels(Data[] d, String title){
		int counter = 0; //keeps track of the current label
		String [][] seriesLabels = new String[d.length][];
		String[] u;
		//creates the array which will contain the title of each type fo data being compared
		if (title.toLowerCase().contains(" vs. ")) {
			u = title.split(" vs. ");
		}
		else {
			u = title.split(" and ");
		}
		//uses the datasets grouping to determine how to group their labels, sets the appropriate index the right label
		for (int i = 0; i < d.length; i++) {
			seriesLabels[i] = new String[d[i].getDataset().length];
			for (int k = 0; k < d[i].getDataset().length; k++) {
				seriesLabels[i][k] = u[counter];
				counter++;
			}
		}
		return seriesLabels;
	}
	
	/**
	 * groups the units by concatinating units according to the grouping of the datasets
	 * @param d Data[] which dictates the grouping of the units
	 * @param units : String[] which contains the units from the analysis
	 * @return String[] which has the grouped together units
	 */
	private String[] convertUnits (Data[] d, String[] units) {
		String[] output = new String[d.length];
		int counter = 0; //keeps track of the current unit
		//uses datasets to determine which units to combine into one string
		for (int i = 0; i < d.length; i++) {
			String temp = units[counter];
			counter++;
			for (int k = 1; k < d[i].getDataset().length; k++) {
				temp += " & "+units[counter];
				counter++;
			}
			output [i] = temp;
		}
		
		return output;
	}
}
