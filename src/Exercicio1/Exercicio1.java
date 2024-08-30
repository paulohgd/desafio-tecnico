package Exercicio1;

public class Exercicio1 {
    public static void main(String[] args) {
        int indice = 13;
        int soma = 0;
        int K = 0;
        //Enquanto o K ser menor que o indice soma 1 e a soma recebe a soma + o K
        while(K < indice){
            K+=1;
            soma+=K;
        }
        //Imprimindo a soma
        System.out.println(soma);
    }
}
