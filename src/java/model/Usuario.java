package model;

import java.util.ArrayList;
import model.framework.DataAccessObject;

public class Usuario extends DataAccessObject {
    
    // Atributos que fazem relação das colunas da tabela 'usuarios' no banco
    private int id; // primary key - id do usuario
    private String nome;
    private String cpf;
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

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public int getTipoUsuarioId() {
        return tipoUsuarioId;
    }

    // Setters, para alterar os atributos e com o addChange() ja muda no dirtyFields
    public void setId(int id) {
        this.id = id;
        addChange("id", this.id);
    }

    public void setNome(String nome) {
        this.nome = nome;
        addChange("nome", this.nome);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        addChange("cpf", this.cpf);
    }

    public void setSenha(String senha) {
        if (this.senha == null) {
            if (senha != null) {
                this.senha = senha;
                addChange("senha", this.senha);
            }
        } else {
            if (senha == null) {
                this.senha = null;
                addChange("senha", this.senha);
            } else {
                if (this.senha.equals(senha) == false) {
                    this.senha = senha;
                    addChange("senha", this.senha);
                }
            }
        }
        this.senha = senha;
        addChange("senha", this.senha);
    }

    public void setTipoUsuarioId(int tipoUsuarioId) {
        if (this.tipoUsuarioId != tipoUsuarioId) {
            this.tipoUsuarioId = tipoUsuarioId;
            addChange("tipo_usuario_id", this.tipoUsuarioId);
        }
    }
    
    @Override
    protected String getWhereClauseForOneEntity() {
        return " id = " + getId();
    }

    // preenche o objeto com os dados do banco
    @Override
    protected DataAccessObject fill(ArrayList<Object> data) {
        // segue a ordem das colunas da tabela usuarios (tem que ver certinho se esta desta forma)
        id = (int) data.get(0); // coluna 1
        nome = (String) data.get(1); // coluna 2
        cpf = (String) data.get(2); // coluna 3
        senha = (String) data.get(3); // coluna 4
        tipoUsuarioId = (int) data.get(4); // coluna 5
        
        return this;
    }

    @Override
    protected Usuario copy() {
        Usuario cp = new Usuario();
        
        cp.setId(getId());
        cp.setNome(getNome());
        cp.setCpf(getCpf());
        cp.setSenha(getSenha());
        cp.setTipoUsuarioId(getTipoUsuarioId());
        
        cp.setNovelEntity(false); // copiou um existente
        
        return cp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Usuario) {
            Usuario aux = (Usuario) obj;
            if (getId() == aux.getId()) {
                return true;
            } else return false;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "(" + getId() + ", " + getNome() + ", " + getCpf() + ", " + getSenha() + ", tipoUsuarioId=" + getTipoUsuarioId() + ")";
    }
}