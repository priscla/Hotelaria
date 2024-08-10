package br.edu.ifpe.apoo.negocio;
import  br.edu.ifpe.apoo.entidades.Hospede;

import java.util.List;
import br.edu.ifpe.apoo.persistencia.FabricaDAO;
import br.edu.ifpe.apoo.persistencia.IHospedeDAO;

public class ControladorHospede implements IControladorHospede {
	private boolean verificar(Hospede hospede) {
		return true;
		
		
	}
	


    @Override
    public void inserir(Hospede hospede) throws ExcecaoNegocio {
        if (!verificar(hospede)) {
        	
        	
            throw new ExcecaoNegocio("Hóspede cadastrado!");
        }
        IHospedeDAO hospedeDao=FabricaDAO.getHospedeDAO();
        hospedeDao.inserir(hospede);

        
        
    }
       
    
    
    @Override
    public void editar(Hospede hospede) throws ExcecaoNegocio {
        if (!verificar(hospede)) {
            throw new ExcecaoNegocio("Hospede invalido");
        }
        IHospedeDAO hospedeDao=FabricaDAO.getHospedeDAO();
        hospedeDao.editar(hospede);

        
    }
    @Override
    public Hospede remover(String cpf) throws ExcecaoNegocio {
    	 IHospedeDAO hospedeDao=FabricaDAO.getHospedeDAO();
    	 return hospedeDao.remover(cpf);
    	
    }
    	
    
       
    
    
    public Hospede consultarHospede(String cpf) {
    	 IHospedeDAO hospedelDao=FabricaDAO.getHospedeDAO();
    	 return
         hospedelDao.consultar(cpf);
    	
       
        }
   

	@Override
	public List<Hospede>listarTodos() {
		// TODO Auto-generated method stub
		IHospedeDAO hospedeDao=FabricaDAO.getHospedeDAO();
   	 return hospedeDao.listarTodos();
   	
		
	}

	
	}

	
	
   
