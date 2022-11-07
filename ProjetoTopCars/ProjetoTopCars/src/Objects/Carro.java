/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author alope
 */
public class Carro {
    private String Marca;
    private String Ano;
    private String Modelo;
    private String Carroceria;
    private String Motor;
    private String Combustivel;
    
    public Carro(){
        
    }
    public String getMarca(){
        return(this.Marca);
    }
    public void setMarca(String Marca){
        this.Marca = Marca;
    }
    public String getAno(){
        return(this.Ano);
    }
    public void setAno(String Ano){
        this.Ano = Ano;
    }
    public String getModelo(){
        return(this.Modelo);
    }
    public void setModelo(String Modelo){
        this.Modelo = Modelo;
    }
    public String getCarroceria(){
        return(this.Carroceria);
    }
    public void setCarroceria(String Carroceria){
        this.Carroceria = Carroceria;
    }
    public String getMotor(){
        return(this.Motor);
    }
    public void setMotor(String Motor){
        this.Motor = Motor;
    }
    public String getCombustivel(){
        return(this.Combustivel);
    }
    public void setCombustivel(String Combustivel){
        this.Combustivel = Combustivel;
    }
    public void cadastrarCarro(Carro novoCarro){
        
    }
    public void limparCarro(){
        this.Motor = " ";
        this.Ano = " ";
        this.Combustivel = " ";
        this.Marca = " ";
        this.Modelo = " ";
        this.Carroceria = " ";
    }
}
