package pt.ipleiria.estg.dei.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   int numero1;
   String operador;

    TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResultado = findViewById(R.id.tvResultado);

        Button num0 = findViewById(R.id.button0);
        Button num1 = findViewById(R.id.button1);
        Button num2 = findViewById(R.id.button2);
        Button num3 = findViewById(R.id.button3);
        Button num4 = findViewById(R.id.button4);
        Button num5 = findViewById(R.id.button5);
        Button num6 = findViewById(R.id.button6);
        Button num7 = findViewById(R.id.button7);
        Button num8 = findViewById(R.id.button8);
        Button num9 = findViewById(R.id.button9);

        Button ac = findViewById(R.id.buttonReset);
        Button dividir = findViewById(R.id.buttonDividir);
        Button somar = findViewById(R.id.buttonMais);
        Button multiplicar = findViewById(R.id.buttonX);
        Button subtrair = findViewById(R.id.buttonMenos);
        Button enter = findViewById(R.id.buttonEnter);
        Button apagar = findViewById(R.id.buttonApagar);


        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for(Button num :nums){
            num.setOnClickListener(view -> {
                if(!tvResultado.getText().toString().equals("0")){
                    tvResultado.setText(tvResultado.getText().toString() + num.getText().toString());
                } else {
                    tvResultado.setText(num.getText().toString());
                }
            });
        }


       /* public void onClickButton(View view) {
            Button clickedButton = (Button) view;
            String buttonText = clickedButton.getText().toString();
            String currentText = tvResultado.getText().toString();

            if (currentText.equals("0")) {
                tvResultado.setText(buttonText);
            } else {
                tvResultado.setText(currentText + buttonText);
            }
        }*/


        ArrayList<Button> sinais = new ArrayList<>();
        sinais.add(dividir);
        sinais.add(multiplicar);
        sinais.add(subtrair);
        sinais.add(multiplicar);
        for (Button sinal :sinais){
            sinal.setOnClickListener(view -> {
                numero1 = Integer.parseInt(tvResultado.getText().toString());
                operador = sinal.getText().toString();
                tvResultado.setText("");
            });
        }

    }

    public void Reset(View view) {
        tvResultado.setText("0");
    }

    public void Apagar(View view) {
        String num = tvResultado.getText().toString();
        if (num.length()>1){
            tvResultado.setText(num.substring(0,num.length()-1)); // perceber melhor a função substring
        } else if (num.length()==1 && !num.equals("0")){
            tvResultado.setText("0");
        }
    }

    public void enter(View view) {
        int numero2 = Integer.parseInt(tvResultado.getText().toString());
        int result;
        switch (operador){
            case "+":
                result = numero1+numero2;
                break;
            case "-":
                result = numero1-numero2;
                break;
            case "/":
                result = numero1/numero2;
                break;
            default:
                result = numero1*numero2;
        }
        tvResultado.setText(String.valueOf(result));
        //numero1 = result;
    }
}