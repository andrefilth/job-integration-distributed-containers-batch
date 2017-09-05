package br.com.cea.transporte.integration.distributed.model;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import lombok.Data;

@NamedStoredProcedureQuery(name = "VoltaModel.viajes", procedureName = "SP_UPDATE_T_RYE_VIAJES", parameters = {
		 @StoredProcedureParameter(mode = ParameterMode.IN, name = "nome", type = String.class)
		,@StoredProcedureParameter(mode = ParameterMode.IN, name = "idade", type = Integer.class)
		,@StoredProcedureParameter(mode = ParameterMode.OUT, name = "volta", type = String.class) 
		}
, resultClasses = VoltaModel.class
)

@Data
public class VoltaModel {

	// private static final long serialVersionUID = 1L;ssss
//	private String nome;
//
//	private Integer idade;
	
	private String volta;

}
