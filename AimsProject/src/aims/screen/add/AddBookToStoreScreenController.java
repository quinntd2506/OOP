package aims.screen.add;

import aims.media.Book;
import aims.media.CompactDisc;
import aims.media.Track;
import aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class AddBookToStoreScreenController {
    private Store store;

    public void setStore(Store store) {
		this.store = store;
	}

    @FXML
    private TextField fieldTitle;

	@FXML
    private TextField fieldCategory;

    @FXML
    private TextField fieldAuthors;

    @FXML
    private Spinner<Double> spinnerCost;

    @FXML
    void initialize() {
    	RoundedSpinnerMaker.makeRoundedSpinner(spinnerCost, 0, 100, 0, 0.05);

    	System.out.println("ADD BOOK INITIALIZED 5");
    }

    @FXML
    void addBook(ActionEvent event) {
		Track track1 = new Track("Miracle", 210);
		Track track2 = new Track("About You", 230);
		Track track3 = new Track("Moonshine", 180);
		Track track4 = new Track("Melancolia", 200);
		Track track5 = new Track("Plume", 180);
		Track track1_x = new Track("Miracle", 180);
		CompactDisc cd1 = new CompactDisc("Chronologic", "Electro Swing", 52.50f, "Caravan Palace");
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd1.addTrack(track3);
		cd1.addTrack(track4);
		cd1.addTrack(track5);
		cd1.addTrack(track1_x);

		Book newBook = new Book(
    		fieldTitle.getText(),
    		fieldCategory.getText(),
    		spinnerCost.getValue().floatValue()
		);

		for (String author : fieldAuthors.getText().split(",")) {
			author = author.strip();
			if (!author.isEmpty()) {
				newBook.addAuthor(author);
			}
		}

    	store.addMedia(newBook);


		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Added book");
		alert.setHeaderText(null);
		alert.setContentText("The book " + fieldTitle.getText() + " was added!");
		alert.showAndWait();


		fieldTitle.clear();
		fieldCategory.clear();
		fieldAuthors.clear();
		spinnerCost.getValueFactory().setValue(0.0);
    }

}
