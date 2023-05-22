// Definição da classe chamada ConsumoAgua que contém métodos para calcular o consumo de água, verificar a categoria de consumo e calcular o preço do consumo.
package app;
public class ConsumoAgua {
    //A classe possui dois atributos públicos, leituraAnterior e leituraAtual, que representam as leituras de água.
    private float leituraAnterior;
    private float leituraAtual;
    private static float tarifaBasica = 10.0f; // valor da tarifa básica de água e esgoto
    private static float taxaAdicional = 1.5f; // valor da taxa adicional
    private static float imposto = 0.05f; // valor do imposto

    public float calculaConsumoAgua(){
        /* O método calculaConsumoAgua() é responsável por calcular o consumo de água, retornando o resultado em forma de um valor float. 
        Ele utiliza as variáveis leituraAnterior e leituraAtual, que foram definidas como atributos da classe ConsumoAgua, para realizar o cálculo. */ 

        this.setLeituraAnterior(leituraAnterior);
        this.setLeituraAtual(leituraAtual);
        //Primeiro, ele chama os métodos setLeituraAnterior() e setLeituraAtual() para atualizar os valores dessas variáveis com os valores passados como parâmetros.

        float consumoAgua = leituraAtual - leituraAnterior;
        //Em seguida, o consumo de água é calculado como a diferença entre as leituras atual e anterior.

        return consumoAgua;
        //Por fim, o valor do consumo é retornado pelo método.
    }
    
    public String checkCategoria(){
        //O método checkCategoria() calcula o consumo de água e retorna a categoria correspondente, com base em uma escala predefinida.
        
        float consumoAgua = calculaConsumoAgua();
        //Primeiro, ele calcula o consumo de água chamando a função "calculaConsumoAgua()" armazenando o resultado na variável "consumoAgua".
        String categoria;
        
        if (consumoAgua <= 10){
            categoria = "Categoria 1"; 
        } else if (consumoAgua <= 20) {
            categoria = "Categoria 2"; 
        } else if (consumoAgua <= 30) {
            categoria = "Categoria 3"; 
        } else {
            categoria = "Categoria 4"; 
        }
        /* Em seguida, é feita uma avaliação do consumo de água em relação a uma escala predefinida de categorias. 
        Se o consumo de água é menor ou igual a 10, a categoria é definida como "Categoria 1". 
        Se o consumo de água estiver entre 11 e 20, a categoria é definida como "Categoria 2". 
        Se o consumo de água estiver entre 21 e 30, a categoria é definida como "Categoria 3". 
        Qualquer valor acima de 30 resultará na categoria "Categoria 4". */

        return categoria;
        //Por fim, a função retorna a categoria correspondente como uma string.
    }

    public float calculaPrecoConsumo(){
        /* O método calculaPrecoConsumo() calcula o preço do consumo de água de acordo com a categoria do cliente e 
        a quantidade de água consumida.*/

        float consumoAgua = calculaConsumoAgua();
        String categoria = checkCategoria();
        
        /* Primeiro, ele chama o método "calculaConsumoAgua" para obter a quantidade de água consumida pelo cliente e o método "checkCategoria" 
        para obter a categoria do cliente. Em seguida, ele inicializa algumas variáveis ​​como a "tarifaBasica", "taxaAdicional" e "imposto", 
        que são usadas no cálculo final do preço. */
        
        float precoConsumoAgua = 0.0f;
        if (categoria.equals("Categoria 1")) {
            precoConsumoAgua = consumoAgua * 0.5f;
        } else if (categoria.equals("Categoria 2")) {
            precoConsumoAgua = consumoAgua * 0.8f;
        } else if (categoria.equals("Categoria 3")) {
            precoConsumoAgua = consumoAgua * 1.2f;
        } else if (categoria.equals("Categoria 4")) {
            precoConsumoAgua = consumoAgua * 1.5f;
        }
        /* Em seguida, é feita uma verificação em qual categoria o cliente se enquadra para calcular o preço de acordo 
        com as taxas específicas da categoria.  */
      
        float precoFinal = precoConsumoAgua + tarifaBasica + (precoConsumoAgua * taxaAdicional) + (precoConsumoAgua * imposto);
        /* Por fim, o método soma o preço do consumo de água com a tarifa básica, a taxa adicional e o imposto, para chegar ao preço final
        que é armazenado na variável "precoFinal" e retornado pelo método. */
        return precoFinal;
    }
    
    public void setLeituraAnterior(float leituraAnterior) {
        this.leituraAnterior = leituraAnterior;
    }
    public float getLeituraAnterior() {
        return this.leituraAnterior;
    }
    public void setLeituraAtual(float leituraAtual) {
        this.leituraAtual = leituraAtual;
    }
    public float getLeituraAtual() {
        return this.leituraAtual;
    }

    /* Os métodos set e get são usados para acessar e modificar essas variáveis. 
    O método setLeituraAnterior () atribui o valor da leitura anterior passada como parâmetro para a variável leituraAnterior da classe. 
    O método getLeituraAnterior () retorna o valor atual da variável leituraAnterior.  

    Esses métodos permitem que outras classes acessem e modifiquem as variáveis ​​de leitura da classe de maneira controlada, por meio de métodos específicos, 
    garantindo assim a integridade dos dados e o encapsulamento dos detalhes internos da classe. */
}
