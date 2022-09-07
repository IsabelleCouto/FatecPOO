package model;

public class Conta {
    private int numConta;
    private String nome;
    private double saldo;

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numConta=" + numConta + "\n" +
                "nome=" + nome + '\'' + "\n" +
                "saldo=" + saldo + "\n" +
                '}';
    }
    public boolean depositar(double valor){
        if(valor>0) {
            saldo+= valor;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor){
        if(valor<=saldo){
            saldo -=valor;
            return true;
        }
        return false;
    }
}
