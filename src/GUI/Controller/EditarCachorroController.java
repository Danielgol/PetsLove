package GUI.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import GUI.System.CadastrarCachorroApp;
import GUI.System.EditarCachorroApp;
import GUI.System.SeusAnimaisApp;
import PetsLove.sistema.FachadaPL;
import PetsLove.sistema.negocios.beans.Animal;
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

	public static Cachorro selecionado;

	@FXML private TextArea taDescricao;
	@FXML private TextField tfNome;
	@FXML private DatePicker dpDataDeNascimento;
	@FXML private ComboBox<String> cbSexo;
	@FXML private ComboBox<String> cbTamanho;
	@FXML private ComboBox<String> cbRaca;

	ObservableList<String> sexo = FXCollections.observableArrayList(EnumSexo.MACHO.valor, EnumSexo.FEMEA.valor);
	ObservableList<String> tamanho = FXCollections.observableArrayList(EnumTamanho.ALTO.valor, EnumTamanho.BAIXO.valor, EnumTamanho.MEDIO.valor);
	ObservableList<String> raca = FXCollections.observableArrayList(EnumRacaCachorro.getValues());

	@FXML
	void handleCancelar( ) {
		selecionado = null;
		SeusAnimaisApp seusAnimaisTela = new SeusAnimaisApp();
		EditarCachorroApp.getStage().close();
		try {
			seusAnimaisTela.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void handleSalvar() {

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
			}
		}

		EnumRacaCachorro raca = null;
		for(EnumRacaCachorro e: EnumRacaCachorro.values()){
			if(e.valor.equals(cbRaca.getValue())){
				raca = e;
			}
		}

		if(selecionado == null){
			//TODO: Tirar esse pritln ladkoaekdoadlaedk
			System.out.println("NULOOOOOOOOOOOOOOOOOO IDIOTA");
		}

		selecionado.setNome(tfNome.getText());
		selecionado.setIdade(idade);
		selecionado.setDescricao(taDescricao.getText());
		selecionado.setRaca(raca);
		selecionado.setTamanho(tamanho);
		selecionado.setSexo(sexo);

		FachadaPL.getInstance().atualizarAnimal(selecionado);

		SeusAnimaisApp seusAnimais = new SeusAnimaisApp();
		EditarCachorroApp.getStage().close();

		try {
			seusAnimais.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setSelecionado(Animal animal) {
		if(FachadaPL.getUsuarioLogado().equals(FachadaPL.getInstance().procurarUsuario(animal.getEmailDono()))) {
			selecionado = (Cachorro) animal;
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cbSexo.setItems(sexo);
		cbTamanho.setItems(tamanho);
		cbRaca.setItems(raca);
	}

}
