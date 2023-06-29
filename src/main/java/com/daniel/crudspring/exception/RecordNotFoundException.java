package com.daniel.crudspring.exception;

public class RecordNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID = 1;

    public RecordNotFoundException(long id){
        super("Registro não encontrado com o id:"+ id);
    }
}
