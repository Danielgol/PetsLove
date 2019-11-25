package GUI.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import GUI.System.CadastrarCachorroApp;
import GUI.System.SeusAnimaisApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.negocios.beans.Cachorro;
import PetsLove.sistema.negocios.beans.enums.EnumRacaCachorro;
import PetsLove.sistema.negocios.beans.enums.EnumSexo;
import PetsLove.sistema.negocios.beans.enums.EnumTamanho;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarCachorroController implements Initializable{

	@FXML private ComboBox<String> cbSexo;
	@FXML private ComboBox<String> cbRaca;
	@FXML private TextArea taDescricao;
	@FXML private TextField tfNome;
	@FXML private DatePicker dpDataDeNascimento;
	@FXML private ComboBox<String> cbTamanho;

	ObservableList<String> sexo = FXCollections.observableArrayList(EnumSexo.MACHO.valor, EnumSexo.FEMEA.valor);
	ObservableList<String> tamanho = FXCollections.observableArrayList(EnumTamanho.ALTO.valor, EnumTamanho.BAIXO.valor, EnumTamanho.MEDIO.valor);
	ObservableList<String> raca = FXCollections.observableArrayList(EnumRacaCachorro.getValues());

	@FXML
	void handleCadastrar( ) {

		//TODO: Colocar Regras de Cadastro (Todos os campos devem ser preenchidos)

		int idade = Period.between(dpDataDeNascimento.getValue(), LocalDate.now()).getYears();

		EnumSexo sexo = null;
		if(cbSexo.getValue().equals(EnumSexo.MACHO.valor)){
			sexo = EnumSexo.MACHO;
		}else if(cbSexo.getValue().equals(EnumSexo.FEMEA.valor)){
			sexo = EnumSexo.FEMEA;
		}

		EnumTamanho tamanho = null;
		for(EnumTamanho e: EnumTamanho.values()){
			if(e.valor.equals(cbTamanho.getValue())){
				tamanho = e;
				break;
			}
		}

		EnumRacaCachorro raca = null;
		for(EnumRacaCachorro e: EnumRacaCachorro.values()){
			if(e.valor.equals(cbRaca.getValue())){
				raca = e;
				break;
			}
		}

		Cachorro cachorro = new Cachorro(FachadaPL.getInstance().listarAnimaisPorDono(FachadaPL.getUsuarioLogado()).size()+1, 
				idade,  sexo, tfNome.getText(), FachadaPL.getUsuarioLogado().getEmail(), 
				raca, tamanho, taDescricao.getText());
		FachadaPL.getInstance().cadastrarAnimal(cachorro);


		SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
		CadastrarCachorroApp.getStage().close();

		try {
			seusAnimais.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleCancelar() {
		SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
		CadastrarCachorroApp.getStage().close();

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
