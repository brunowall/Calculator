package com.example.darkbyte.calculator.views;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.darkbyte.calculator.R;
import com.example.darkbyte.calculator.controllers.Calculator;

/**
 * Created by darkbyte on 19/08/17.
 */

public class MainActivity extends Activity {
    private TextView visorNumeros;
    Calculator calculator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        this.visorNumeros = (TextView) findViewById(R.id.visorNumeros);
        this.visorNumeros.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                contextMenu.add(Menu.NONE,1,Menu.NONE,"Limpar");
            }
        });

        calculator =  new Calculator();
    }

    public void numberClick(View view){
        Button button = (Button) view;
        if(visorNumeros.getText().toString().equals("0")){
            visorNumeros.setText(button.getText());
            return;
        }

        String texto  = visorNumeros.getText().toString() + button.getText().toString();
        visorNumeros.setText(texto);
    }

    public  void  sumClick(View view){
        this.calculator.setNum1(Float.parseFloat(visorNumeros.getText().toString()));
        this.calculator.setOp('+');
        this.visorNumeros.setText("0");
    }

    public void equalClick(View view){
        this.calculator.setNum2(Float.parseFloat(visorNumeros.getText().toString()));
        this.visorNumeros.setText(""+calculator.execOperation());
        this.calculator.setOp('n');
    }
    public void divClick(View view){
        this.calculator.setNum1(Float.parseFloat(visorNumeros.getText().toString()));
        this.calculator.setOp('/');
        this.visorNumeros.setText("0");
    }

    public void subClick(View view){
        this.calculator.setNum1(Float.parseFloat(visorNumeros.getText().toString()));
        this.calculator.setOp('-');
        this.visorNumeros.setText("0");

    }
    public void multiClick(View view){
        this.calculator.setNum1(Float.parseFloat(visorNumeros.getText().toString()));
        this.calculator.setOp('*');
        this.visorNumeros.setText("0");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==1){
            this.visorNumeros.setText("0");
        }
        return super.onContextItemSelected(item);
    }
}
