package br.com.cea.transporte.integration.distributed.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@NamedStoredProcedureQuery(name = "PalletsModel.pallets", procedureName = "sp_update_t_rye_pallets", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "destino", type = Integer.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "cajas", type = Integer.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "unidades", type = Integer.class),
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "piezas", type = Integer.class),
		  @StoredProcedureParameter(mode = ParameterMode.OUT, name = "retorno", type = String.class),
		  })
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "T_RYE_PALLETS")
public class PalletsModel extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id_pallet")
	private Long id;

	@Column(name = "suc_destino")
	private Integer destino;

	@Column(name = "piezas")
	private Integer piezas;

	@Column(name = "cajas")
	private Integer cajas;

	
	@Column(name = "volumenes")
	private Integer volumenes;

	@Column(name = "adicionales")
	private Integer adicionales;

	@Column(name = "transferencias")
	private Integer transferencias;

	@Column(name = "viaje")
	private Integer viaje;

	@Column(name = "fec_envio")
	private Date fecEnvio;

	@Column(name = "comentario")
	private String comentario;

	@Column(name = "status")
	private Integer status;
	
	
}
