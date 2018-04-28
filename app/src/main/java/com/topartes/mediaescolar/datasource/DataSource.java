package com.topartes.mediaescolar.datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.topartes.mediaescolar.adapter.ResultadoFinalListAdapter;
import com.topartes.mediaescolar.controller.MediaEscolarCtrl;
import com.topartes.mediaescolar.datamodel.MediaEscolarDataModel;
import com.topartes.mediaescolar.model.MediaEscolar;

import java.util.ArrayList;
import java.util.List;

public class DataSource extends SQLiteOpenHelper{

    private static final String DB_NAME = "media_escolar.sqlite";
    private static final int DB_VERSION = 1;

    static Cursor cursor;
    static SQLiteDatabase db;

    /**
     * Abre banco de dados para edição
     * @param context
     */

    public DataSource(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    /**
     * Cria a tabela no banco de dados com os atributos definidos
     * @param db
     * @see com.topartes.mediaescolar.datamodel
     */

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(MediaEscolarDataModel.criarTabela());

        } catch (Exception e) {

            Log.e("Media", "DB---> ERRO: " + e.getMessage());

        }

    }

    /**
     * Atualiza alterações na estrutura do banco de dados
     * @param db
     * @param oldVersion
     * @param newVersion
     * @see com.topartes.mediaescolar.datamodel
     */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Insere novos registros na tabela criada
     * @param tabela
     * @param dados
     * @see com.topartes.mediaescolar.controller
     * @return boolean Sucesso se alterado
     */

    public boolean insert(String tabela, ContentValues dados){
        boolean sucesso = true;
        try{
            sucesso = db.insert(tabela, null, dados) > 0;
        }catch (Exception e){
            sucesso = false;
            Log.e("Insert", "ERRO ------> BD" + e.getMessage());
        }
        return sucesso;
    }

    /**
     * Altera os registros da tabela de acordo com o ID
     * @param tabela
     * @param dados
     * @see com.topartes.mediaescolar.controller
     * @return boolean Sucesso se alterado
     */

    public boolean alterar(String tabela, ContentValues dados){
        boolean sucesso = true;
        int id = dados.getAsInteger("id");
        try{
            sucesso = db.update(tabela, dados, "id=?", new String[]{Integer.toString(id)}) > 0;

        }catch (Exception e) {
            sucesso = false;
            Log.e("Editar", "ERRO -------- Id"+ e.getMessage());
        }
        return sucesso;
    }

    /**
     * Deleta registros da tabela de acordo com o ID
     * @param tabela
     * @param id
     * @see com.topartes.mediaescolar.controller
     * @return
     */

    public boolean deletar(String tabela, int id){
        boolean sucesso = true;
        sucesso = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;

        return sucesso;
    }

    /**
     * Lista todos os registros da tabela
     * @return List <lista>Id e Matéria</lista>
     */

    public static List<MediaEscolar> getAllMediaEscolar() {
        MediaEscolar obj;

        List<MediaEscolar> lista = new ArrayList<>();

        String sql = "SELECT * FROM "+ MediaEscolarDataModel.getTABELA() + " ORDER BY id ASC";
        cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                obj = new MediaEscolar();
                obj.setId(cursor.getInt(cursor.getColumnIndex(MediaEscolarDataModel.getId())));
                obj.setBimestre(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getBimestre())));
                obj.setMateria(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getMateria())));
                obj.setNotaProva(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getNotaProva())));
                obj.setNotaTrabalho(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getNotaMateria())));
                obj.setMediaFinal(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getMediaFinal())));
                obj.setSituacao(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getSituacao())));

                lista.add(obj);

            }while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }

    public static ArrayList<MediaEscolar> getAllResultadoFinal() {
        MediaEscolar obj;

        ArrayList<MediaEscolar> lista = new ArrayList<>();

        String sql = "SELECT * FROM "+ MediaEscolarDataModel.getTABELA() + " ORDER BY id ASC";
        cursor = db.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do{
                obj = new MediaEscolar();

                obj.setId(cursor.getInt(cursor.getColumnIndex(MediaEscolarDataModel.getId())));
                obj.setBimestre(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getBimestre())));
                obj.setMateria(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getMateria())));
                obj.setNotaProva(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getNotaProva())));
                obj.setNotaTrabalho(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getNotaMateria())));
                obj.setMediaFinal(cursor.getDouble(cursor.getColumnIndex(MediaEscolarDataModel.getMediaFinal())));
                obj.setSituacao(cursor.getString(cursor.getColumnIndex(MediaEscolarDataModel.getSituacao())));

                lista.add(obj);

            }while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }
}
