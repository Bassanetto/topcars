/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author jr-mu
 */
public class Logins {
    private String Nome;
    private String Sobrenome;
    private String CPF;
    private String Email;
    
    public Logins(){
    
}
    public String getNome(){
        return(this.Nome);
    }
    public void setNome(String Nome){
        this.Nome = Nome;
    }
    public String getSobrenome(){
        return(this.Sobrenome);
    }
    public void setSobrenome(String Sobrenome){
        this.Sobrenome = Sobrenome;
    }
    public String getEmail(){
        return(this.Email);
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public String getCPF(){
        return(this.CPF);
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
}
