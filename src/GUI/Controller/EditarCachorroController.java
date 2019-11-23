package GUI.Controller;


import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;

import GUI.System.CadastrarCachorroApp;
import GUI.System.EditarCachorroApp;
import GUI.System.SeusAnimaisApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.EnumRacaCachorro;
import PetsLove.sistema.negocios.beans.EnumSexo;
import PetsLove.sistema.negocios.beans.EnumTamanho;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarCachorroController implements Initializable{

	  @FXML
	    private TextArea taDescricao;

	    @FXML
	    private TextField tfNome;

	    @FXML
	    private DatePicker dpDataDeNascimento;

	    @FXML
	    private ComboBox<String> cbSexo;

	    @FXML
	    private ComboBox<String> cbTamanho;

	    @FXML
	    private ComboBox<String> cbRaca;


		ObservableList<String> sexo = FXCollections.observableArrayList(EnumSexo.MACHO.sexo, EnumSexo.FEMEA.sexo);
		ObservableList<String> tamanho = FXCollections.observableArrayList(EnumTamanho.ALTO.tamanho, EnumTamanho.BAIXO.tamanho, EnumTamanho.MEDIO.tamanho);
		ObservableList<String> raca = FXCollections.observableArrayList(EnumRacaCachorro.getValues());
		
    @FXML
    void handleCancelar( ) {
    	SeusAnimaisApp seusAnimaisTela = new SeusAnimaisApp();
    	EditarCachorroApp.getStage().close();
    	try {
			seusAnimaisTela.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void handleSalvar() {

    	int idade = Period.between(dpDataDeNascimento.getValue(), LocalDate.now()).getYears();
		EnumSexo sexo = null;
		if(cbSexo.getValue().equals(EnumSexo.MACHO.sexo)){
			sexo = EnumSexo.MACHO;
		}
		else if(cbSexo.getValue().equals(EnumSexo.FEMEA.sexo)){
			sexo = EnumSexo.FEMEA;
		}

		EnumTamanho tamanho = null;
		for(EnumTamanho e: EnumTamanho.values()){
			if(e.tamanho.equals(cbTamanho.getValue())){
				tamanho = e;
			}
		}

		EnumRacaCachorro raca = null;
		for(EnumRacaCachorro e: EnumRacaCachorro.values()){
			if(e.valor.equals(cbRaca.getValue())){
				raca = e;
			}
		}

		Cachorro cachorro = new Cachorro(FachadaPL.getInstance().listarAnimaisPorDono(FachadaPL.getInstance().getUsuarioLogado()).size()+1, 
				idade,  sexo, tfNome.getText(), FachadaPL.getInstance().getUsuarioLogado(), 
				raca, tamanho, taDescricao.getText());
		FachadaPL.getInstance().atualizarAnimal(cachorro);
		System.out.println("Cão: " + cachorro.getNome());
		
		SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
		EditarCachorroApp.getStage().close();

		try {
			seusAnimais.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		cbSexo.setItems(sexo);
		cbTamanho.setItems(tamanho);
		cbRaca.setItems(raca);
	}

}
