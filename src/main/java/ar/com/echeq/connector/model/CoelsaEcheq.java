package ar.com.echeq.connector.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CoelsaEcheq {

    private Cheque cheque;
    private Respuesta respuesta;

    @Data
    public static class Cheque {
        private int totalFirmantes;
        private List<Firmante> firmantes;
        private int agrupadorId;
        private boolean certificadoEmitido;
        private boolean chequeAcordado;
        private String chequeCaracter;
        private String chequeConcepto;
        private String chequeId;
        private int chequeModo;
        private String chequeMotivoPago;
        private String chequeNumero;
        private String chequeTipo;
        private String cmc7;
        private String codVisualizacion;
        private String codigoEmision;
        private String estado;
        private LocalDateTime fechaEmision;
        private LocalDateTime fechaPago;
        private boolean fechaPagoVencida;
        private double monto;
        private String motivoAnulacion;
        private String motivoRepudioEmision;
        private String motivoDevolucion;
        private String numeroChequera;
        private boolean rePresentar;
        private boolean repudioEndoso;
        private boolean solicitandoAcuerdo;
        private boolean onp;
        private boolean acuerdoRechazado;
        private LocalDateTime fechaUltModif;
        private String cbuCustodia;
        private String cbuDeposito;
        private String cuitSolicDevol;
        private String beneficiarioFinalDocumentoTipo;
        private String beneficiarioFinalDocumento;
        private String nroLote;
        private boolean cedido;
        private boolean cesionPendiente;
        private String beneficiarioFinalNombre;
        private boolean esUltimoEndosante;
        private boolean avalado;
        private boolean mandatoCobro;
        private boolean mandatoNeg;
        private boolean esUltimoMandante;
        private String ultimoEndosanteRazonSocial;
        private CuentaEmisora cuentaEmisora;
        private EmitidoA emitidoA;
        private Tenencia tenencia;
        private int totalEndosos;
        private List<Endoso> endosos;
        private int totalChqReferenciasPago;
        private List<ChqReferenciaPago> chqReferenciasPago;
        private int totalRechazos;
        private List<Rechazo> rechazos;
        private int totalAvalistas;
        private List<Avalista> avalistas;
        private int totalCesiones;
        private List<Cesion> cesiones;


    }

    @Data
    public static class Firmante {
        private String documento;
        private String documentoTipo;


    }

    @Data
    public static class CuentaEmisora {
        private String bancoCodigo;
        private String bancoNombre;
        private String emisorCbu;
        private String emisorCp;
        private String emisorCuenta;
        private String emisorCuit;
        private String emisorDomicilio;
        private String emisorMoneda;
        private String emisorRazonSocial;
        private String emisorSubcuenta;
        private String sucursalCodigo;
        private String sucursalCp;
        private String sucursalDomicilio;
        private String sucursalNombre;
        private String sucursalProvincia;


    }

    @Data
    public static class EmitidoA {
        private String beneficiarioDocumento;
        private String beneficiarioDocumentoTipo;
        private String beneficiarioNombre;


    }

    @Data
    public static class Tenencia {
        private String beneficiarioDocumento;
        private String beneficiarioDocumentoTipo;
        private String beneficiarioNombre;


    }

    @Data
    public static class Endoso {
        private String benefDocumento;
        private String benefDocumentoTipo;
        private String benefRazonSocial;
        private String emisorDocumento;
        private String emisorDocumentoTipo;
        private String emisorRazonSocial;
        private String estadoEndoso;
        private LocalDateTime fechaHora;
        private String motivoRepudio;
        private String tipoEndoso;
        private int totalReferenciasPago;
        private List<ReferenciaPago> referenciasPago;


    }

    @Data
    public static class ReferenciaPago {
        private String referencia;
        private String valor;

    }

    @Data
    public static class ChqReferenciaPago {
        private String referencia;
        private String valor;

    }

    @Data
    public static class Rechazo {
        private String codigoRechazo;
        private String fechaHora;
        private String motivoRechazo;

        
    }

    @Data
    public static class Avalista {
        private String avalDocumentoTipo;
        private String avalDocumento;
        private String avalRazonSocial;
        private String avalCaracter;
        private String avalDomicilio;
        private double avalImporteAvalado;
        private String avalSujetoAvalado;
        private LocalDateTime avalFecha;
        private String avalEntidad;
        private String avalEstado;

        
    }

    @Data
    public static class Cesion {
        private String cesionId;
        private String estadoCesion;
        private String cedenteDocumentoTipo;
        private String cedenteDocumento;
        private String cedenteNombre;
        private String cesionarioDocumento;
        private String cesionarioDocumentoTipo;
        private String cesionarioNombre;
        private String cesionarioDomicilio;
        private String entidadRespRegistracion;
        private String cesionMotivoRepudio;
        private LocalDateTime fechaEmisionCesion;
        private LocalDateTime fechaUltModificacionCesion;

        
    }

    @Data
    public static class Respuesta {
        private String codigo;
        private String descripcion;

        
    }
}