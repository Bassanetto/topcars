/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author alope
 */
public class Clientes {
    private String Nome;
    private String Sexo;
    private String CPF;
    private String Endereco;
    private String Nascimento;
    private String Email;
    private String CNH;
    private String Telefone;
    
    public Clientes(){
    
}
    public String getNome(){
        return(this.Nome);
    }
    public void setNome(String Nome){
        this.Nome = Nome;
    }
    public String getCPF(){
        return(this.CPF);
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }
    public String getSexo(){
        return(this.Sexo);
    }
    public void setSexo(String Sexo){
        this.Sexo = Sexo;
    }
    public String getEndereco(){
        return(this.Endereco);
    }
    public void setEndereco(String Endereco){
        this.Endereco = Endereco;
    }
    public void setNascimento(String Nascimento){
        this.Nascimento = Nascimento;
    }
    public String getNascimento(){
        return(this.Nascimento);
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public String getEmail(){
        return(this.Email);
    }
    public void setCNH(String CNH){
        this.CNH = CNH;            
    }
    public String getCNH(){
        return(this.CNH);
    }
    public void setTelefone(String Telefone){
        this.Telefone = Telefone;
    }
    public String getTelefone(){
        return(this.Telefone);
    }
    public void cadastrarCliente(Clientes novoCliente){
        this.Nome = Nome;
        this.CPF = CPF;
        this.CNH = CNH;
        this.Sexo = Sexo;
        this.Telefone = Telefone;
        this.Endereco = Endereco;
        this.Email = Email;
    }
     public void LimpaCliente(){
        this.Nome = " ";
        this.CPF = " ";
        this.Sexo = " ";      
        this.Endereco = " ";
        this.CNH = " ";    
        this.Nascimento = " ";
        this.Email = " ";
    }
}

