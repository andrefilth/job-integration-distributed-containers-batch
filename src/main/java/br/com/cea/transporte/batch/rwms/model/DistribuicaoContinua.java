package br.com.cea.transporte.batch.rwms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name="ADMRWMS.CYA_V_DIST_CONT")
public class DistribuicaoContinua {
	
	@Id
	@Column(name="FACILITY_ID")
	private String facilityId;
	
	@Column(name="DEST_ID")
	private String destID;
	
	@Column(name="PALLET_QTY")
	private Integer palletQty;
	
	@Column(name="CONT_QTY")
	private Integer contQty;
	
	@Column(name="UNIT_QTY")
	private Integer unitQty;
	
	
	@Column(name="PIECES_QTY")
	private Integer piecesQty;

}
