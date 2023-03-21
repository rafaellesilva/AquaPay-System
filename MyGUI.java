//Criação da interface gráfica do usuário (GUI) para a classe ConsumoAgua que calcula consumo de água e o seu preço. 
package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
//Importação das bibliotecas necessárias para a criação.

public class MyGUI {
    public static void main(String[] args) {
       //Criação do Frame e suas definições como o título, posição e tamanho.
       JFrame frame = new JFrame();
       frame.setTitle("AquaPay");
       frame.setBounds(100, 100, 790, 860);
       
       //Inserção da imagem de fundo do Frame e suas definições como posição e tamanho.
       JLabel background = new JLabel(new ImageIcon("C:\\Users\\rsilva85\\University\\APS\\src\\app\\AquaPay.png")); 
       background.setBounds(0, 0, 790, 860);
       frame.getContentPane().add(background);
       
       /* Criação do contêiner da janela frame e definição do layout para NULL, permitindo que os componentes adicionados possam
       ser posicionados e redimensionados livremente. */
       Container cont = frame.getContentPane();
       cont.setLayout(null);
    
       //Definição do formato de exibição para números em formato float que inclui pelo menos dois dígitos após o ponto decimal. 
       NumberFormat floatFormat = NumberFormat.getNumberInstance();
       floatFormat.setMinimumFractionDigits(2);
       
       //Criação de objetos para solicitar e exibir valores.
       JFormattedTextField field1 = new JFormattedTextField(floatFormat);
       JFormattedTextField field2 = new JFormattedTextField(floatFormat);
       JFormattedTextField showValueConsumo = new JFormattedTextField(floatFormat);
       JFormattedTextField showValuePrecoConsumo = new JFormattedTextField(floatFormat);

       //Definição da posição e tamanho dos objetos
       field1.setBounds(453, 317, 115, 39);
       field2.setBounds(453, 422, 115, 39);
       showValueConsumo.setBounds(404, 625, 115, 39);
       showValuePrecoConsumo.setBounds(404, 712, 115, 39);
       
       //Definição da borda dos objetos para NULL, permitindo uma melhor experiência do usuário.
       field1.setBorder(null);
       field2.setBorder(null);
       showValueConsumo.setBorder(null);
       showValuePrecoConsumo.setBorder(null);
       
       //Definição do fundo dos objetos field1 e field2, permitindo uma melhor experiência do usuário.
       field1.setBackground(new Color(192, 192, 192));
       field2.setBackground(new Color(192, 192, 192));
       
       //Definição do alinhamento dos objetos para centralizado, permitindo uma melhor experiência do usuário.
       field1.setHorizontalAlignment(SwingConstants.CENTER);
       field2.setHorizontalAlignment(SwingConstants.CENTER);
       showValueConsumo.setHorizontalAlignment(SwingConstants.CENTER);
       showValuePrecoConsumo.setHorizontalAlignment(SwingConstants.CENTER);
       
       //Criação da fonte das letras dos objetos para 'DM Sans', permitindo uma melhor experiência do usuário.
       Font font_field1 = new Font("DM Sans", Font.BOLD, 20); 
       Font font_field2 = new Font("DM Sans", Font.BOLD, 20); 
       Font font_showValueConsumo = new Font("DM Sans", Font.BOLD, 20);
       Font font_showValuePrecoConsumo = new Font("DM Sans", Font.BOLD, 20);
       
       //Definição da fonte criada dos objetos, permitindo uma melhor experiência do usuário.
       field1.setFont(font_field1); 
       field2.setFont(font_field2); 
       showValueConsumo.setFont(font_showValueConsumo); 
       showValuePrecoConsumo.setFont(font_showValuePrecoConsumo); 

       //Criação do botão e seu respectivo ícone.
       ImageIcon icon = new ImageIcon("C:\\Users\\rsilva85\\University\\APS\\src\\app\\imgButton.png");
       JButton button = new JButton(icon);
       //Definição da posição,tamanho e borda do botão.
       button.setBounds(261, 505, 267, 46);
       button.setBorder(null);
    
       //Inserção dos objetos e botão no contêiner da janela frame.
       cont.add(button);
       cont.add(field1);
       cont.add(field2);
       cont.add(showValueConsumo);
       cont.add(showValuePrecoConsumo);

       // Criação da action do botão
       ActionListener buttonListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                ConsumoAgua consumoAgua = new ConsumoAgua();
                float leituraAnterior = ((Number) field1.getValue()).floatValue();
                float leituraAtual = ((Number) field2.getValue()).floatValue();
                /* Criação do objeto ConsumoAgua usado para calcular o consumo de água 
                e o preço com base nas leituras de medidores de água fornecidas pelos objetos field1 e field2. */

                consumoAgua.setLeituraAnterior(leituraAnterior);
                consumoAgua.setLeituraAtual(leituraAtual);
                //Definição dos parâmetros do método set para acessar as variáveis.

                float consumo = consumoAgua.calculaConsumoAgua();
                float preco = consumoAgua.calculaPrecoConsumo();
                /* Criação das variáveis consumo e preço que retorna o resultado dos métodos calculaConsumoAgua()
                e calculaPrecoConsumo() após a definição de seus respectivos parâmetros. */

                showValueConsumo.setText(consumo + " m³");
                showValuePrecoConsumo.setText("R$ " + preco);
                //Exibição das variáveis no contêiner da janela frame após a definição e resultado dos métodos requisitados.
            }
        };
       button.addActionListener(buttonListener);
       //Inserção da action ao botão

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //Definição da operação padrão a ser executada quando o usuário fecha a frame
       frame.setResizable(false);
       //Inativa o redimensionamento da frame.
       frame.setVisible(true);
       //Ativa a frame para o usuário tornando interativa.
    }
}
