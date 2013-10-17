/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package no.mesan.miniprosjekt.kommunikasjon.thrift.server;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kaja implements org.apache.thrift.TBase<Kaja, Kaja._Fields>, java.io.Serializable, Cloneable, Comparable<Kaja> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Kaja");

  private static final org.apache.thrift.protocol.TField KJ_FIELD_DESC = new org.apache.thrift.protocol.TField("kj", org.apache.thrift.protocol.TType.LIST, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new KajaStandardSchemeFactory());
    schemes.put(TupleScheme.class, new KajaTupleSchemeFactory());
  }

  public List<Integer> kj; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    KJ((short)1, "kj");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // KJ
          return KJ;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.KJ, new org.apache.thrift.meta_data.FieldMetaData("kj", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32            , "int"))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Kaja.class, metaDataMap);
  }

  public Kaja() {
  }

  public Kaja(
    List<Integer> kj)
  {
    this();
    this.kj = kj;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Kaja(Kaja other) {
    if (other.isSetKj()) {
      List<Integer> __this__kj = new ArrayList<Integer>(other.kj.size());
      for (Integer other_element : other.kj) {
        __this__kj.add(other_element);
      }
      this.kj = __this__kj;
    }
  }

  public Kaja deepCopy() {
    return new Kaja(this);
  }

  @Override
  public void clear() {
    this.kj = null;
  }

  public int getKjSize() {
    return (this.kj == null) ? 0 : this.kj.size();
  }

  public java.util.Iterator<Integer> getKjIterator() {
    return (this.kj == null) ? null : this.kj.iterator();
  }

  public void addToKj(int elem) {
    if (this.kj == null) {
      this.kj = new ArrayList<Integer>();
    }
    this.kj.add(elem);
  }

  public List<Integer> getKj() {
    return this.kj;
  }

  public Kaja setKj(List<Integer> kj) {
    this.kj = kj;
    return this;
  }

  public void unsetKj() {
    this.kj = null;
  }

  /** Returns true if field kj is set (has been assigned a value) and false otherwise */
  public boolean isSetKj() {
    return this.kj != null;
  }

  public void setKjIsSet(boolean value) {
    if (!value) {
      this.kj = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case KJ:
      if (value == null) {
        unsetKj();
      } else {
        setKj((List<Integer>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case KJ:
      return getKj();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case KJ:
      return isSetKj();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Kaja)
      return this.equals((Kaja)that);
    return false;
  }

  public boolean equals(Kaja that) {
    if (that == null)
      return false;

    boolean this_present_kj = true && this.isSetKj();
    boolean that_present_kj = true && that.isSetKj();
    if (this_present_kj || that_present_kj) {
      if (!(this_present_kj && that_present_kj))
        return false;
      if (!this.kj.equals(that.kj))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public int compareTo(Kaja other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetKj()).compareTo(other.isSetKj());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKj()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.kj, other.kj);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Kaja(");
    boolean first = true;

    sb.append("kj:");
    if (this.kj == null) {
      sb.append("null");
    } else {
      sb.append(this.kj);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class KajaStandardSchemeFactory implements SchemeFactory {
    public KajaStandardScheme getScheme() {
      return new KajaStandardScheme();
    }
  }

  private static class KajaStandardScheme extends StandardScheme<Kaja> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Kaja struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // KJ
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.kj = new ArrayList<Integer>(_list0.size);
                for (int _i1 = 0; _i1 < _list0.size; ++_i1)
                {
                  int _elem2;
                  _elem2 = iprot.readI32();
                  struct.kj.add(_elem2);
                }
                iprot.readListEnd();
              }
              struct.setKjIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Kaja struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.kj != null) {
        oprot.writeFieldBegin(KJ_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.kj.size()));
          for (int _iter3 : struct.kj)
          {
            oprot.writeI32(_iter3);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class KajaTupleSchemeFactory implements SchemeFactory {
    public KajaTupleScheme getScheme() {
      return new KajaTupleScheme();
    }
  }

  private static class KajaTupleScheme extends TupleScheme<Kaja> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Kaja struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetKj()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetKj()) {
        {
          oprot.writeI32(struct.kj.size());
          for (int _iter4 : struct.kj)
          {
            oprot.writeI32(_iter4);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Kaja struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.kj = new ArrayList<Integer>(_list5.size);
          for (int _i6 = 0; _i6 < _list5.size; ++_i6)
          {
            int _elem7;
            _elem7 = iprot.readI32();
            struct.kj.add(_elem7);
          }
        }
        struct.setKjIsSet(true);
      }
    }
  }

}
