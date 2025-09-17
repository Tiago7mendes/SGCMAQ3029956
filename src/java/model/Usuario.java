package model;

import java.util.ArrayList;
import model.framework.DataAccessObject;

public class Usuario extends DataAccessObject {
    
    private int id;
    private String nome;
    private String login;
    private String senha;
    private int tipoUsuarioId; // chave estrangeira para tipo_usuario

    public Usuario() {
        super("usuarios"); // nome da tabela
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public int getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    public void setId(int id) {
        this.id = id;
        addChange("id", this.id);
    }

    public void setNome(String nome) {
        this.nome = nome;
        addChange("nome", this.nome);
    }

    public void setLogin(String login) {
        this.login = login;
        addChange("login", this.login);
    }

    public void setSenha(String senha) {
        this.senha = senha;
        addChange("senha", this.senha);
    }

    public void setTipoUsuarioId(int tipoUsuarioId) {
        this.tipoUsuarioId = tipoUsuarioId;
        addChange("tipo_usuario_id", this.tipoUsuarioId);
    }

    @Override
    protected String getWhereClauseForOneEntity() {
        return " id = " + getId();
    }

    @Override
    protected DataAccessObject fill(ArrayList<Object> data) {
        // segue a ordem das colunas da tabela usuarios
        id = (int) data.get(0);
        nome = (String) data.get(1);
        login = (String) data.get(2);
        senha = (String) data.get(3);
        tipoUsuarioId = (int) data.get(4);
        
        return this;
    }

    @Override
    protected Usuario copy() {
        Usuario cp = new Usuario();
        
        cp.setId(getId());
        cp.setNome(getNome());
        cp.setLogin(getLogin());
        cp.setSenha(getSenha());
        cp.setTipoUsuarioId(getTipoUsuarioId());
        
        cp.setNovelEntity(false); // copiou um existente
        
        return cp;
    }
    
    @Override
    public String toString() {
        return "(" + getId() + ", " + getNome() + ", " + getLogin() + ", " + getSenha() + ", tipoUsuarioId=" + getTipoUsuarioId() + ")";
    }
}