/**
 * BeanAseguradora.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portafolio.ws.bean;

public class BeanAseguradora  implements java.io.Serializable {
    private java.lang.String descripcion;

    private java.lang.Boolean estado;

    private int monto;

    private java.lang.String nombre;

    private java.lang.String plan;

    public BeanAseguradora() {
    }

    public BeanAseguradora(
           java.lang.String descripcion,
           java.lang.Boolean estado,
           int monto,
           java.lang.String nombre,
           java.lang.String plan) {
           this.descripcion = descripcion;
           this.estado = estado;
           this.monto = monto;
           this.nombre = nombre;
           this.plan = plan;
    }


    /**
     * Gets the descripcion value for this BeanAseguradora.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this BeanAseguradora.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the estado value for this BeanAseguradora.
     * 
     * @return estado
     */
    public java.lang.Boolean getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this BeanAseguradora.
     * 
     * @param estado
     */
    public void setEstado(java.lang.Boolean estado) {
        this.estado = estado;
    }


    /**
     * Gets the monto value for this BeanAseguradora.
     * 
     * @return monto
     */
    public int getMonto() {
        return monto;
    }


    /**
     * Sets the monto value for this BeanAseguradora.
     * 
     * @param monto
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }


    /**
     * Gets the nombre value for this BeanAseguradora.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this BeanAseguradora.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the plan value for this BeanAseguradora.
     * 
     * @return plan
     */
    public java.lang.String getPlan() {
        return plan;
    }


    /**
     * Sets the plan value for this BeanAseguradora.
     * 
     * @param plan
     */
    public void setPlan(java.lang.String plan) {
        this.plan = plan;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BeanAseguradora)) return false;
        BeanAseguradora other = (BeanAseguradora) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            this.monto == other.getMonto() &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.plan==null && other.getPlan()==null) || 
             (this.plan!=null &&
              this.plan.equals(other.getPlan())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        _hashCode += getMonto();
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getPlan() != null) {
            _hashCode += getPlan().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BeanAseguradora.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bean.ws.portafolio.com", "BeanAseguradora"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.ws.portafolio.com", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.ws.portafolio.com", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.ws.portafolio.com", "monto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.ws.portafolio.com", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://bean.ws.portafolio.com", "plan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
