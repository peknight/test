/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.peknight.test.thrift.reflect;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-08-10")
public class ConstructorInfo implements org.apache.thrift.TBase<ConstructorInfo, ConstructorInfo._Fields>, java.io.Serializable, Cloneable, Comparable<ConstructorInfo> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ConstructorInfo");

  private static final org.apache.thrift.protocol.TField CLASS_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("className", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PARAM_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("paramList", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField MODIFIERS_FIELD_DESC = new org.apache.thrift.protocol.TField("modifiers", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField IS_ACCESSIBLE_FIELD_DESC = new org.apache.thrift.protocol.TField("isAccessible", org.apache.thrift.protocol.TType.BOOL, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ConstructorInfoStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ConstructorInfoTupleSchemeFactory();

  public java.lang.String className; // required
  public java.util.List<ClassInfo> paramList; // required
  public int modifiers; // required
  public boolean isAccessible; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CLASS_NAME((short)1, "className"),
    PARAM_LIST((short)2, "paramList"),
    MODIFIERS((short)3, "modifiers"),
    IS_ACCESSIBLE((short)4, "isAccessible");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // CLASS_NAME
          return CLASS_NAME;
        case 2: // PARAM_LIST
          return PARAM_LIST;
        case 3: // MODIFIERS
          return MODIFIERS;
        case 4: // IS_ACCESSIBLE
          return IS_ACCESSIBLE;
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
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __MODIFIERS_ISSET_ID = 0;
  private static final int __ISACCESSIBLE_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CLASS_NAME, new org.apache.thrift.meta_data.FieldMetaData("className", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PARAM_LIST, new org.apache.thrift.meta_data.FieldMetaData("paramList", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ClassInfo.class))));
    tmpMap.put(_Fields.MODIFIERS, new org.apache.thrift.meta_data.FieldMetaData("modifiers", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.IS_ACCESSIBLE, new org.apache.thrift.meta_data.FieldMetaData("isAccessible", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ConstructorInfo.class, metaDataMap);
  }

  public ConstructorInfo() {
  }

  public ConstructorInfo(
    java.lang.String className,
    java.util.List<ClassInfo> paramList,
    int modifiers,
    boolean isAccessible)
  {
    this();
    this.className = className;
    this.paramList = paramList;
    this.modifiers = modifiers;
    setModifiersIsSet(true);
    this.isAccessible = isAccessible;
    setIsAccessibleIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ConstructorInfo(ConstructorInfo other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetClassName()) {
      this.className = other.className;
    }
    if (other.isSetParamList()) {
      java.util.List<ClassInfo> __this__paramList = new java.util.ArrayList<ClassInfo>(other.paramList.size());
      for (ClassInfo other_element : other.paramList) {
        __this__paramList.add(new ClassInfo(other_element));
      }
      this.paramList = __this__paramList;
    }
    this.modifiers = other.modifiers;
    this.isAccessible = other.isAccessible;
  }

  public ConstructorInfo deepCopy() {
    return new ConstructorInfo(this);
  }

  @Override
  public void clear() {
    this.className = null;
    this.paramList = null;
    setModifiersIsSet(false);
    this.modifiers = 0;
    setIsAccessibleIsSet(false);
    this.isAccessible = false;
  }

  public java.lang.String getClassName() {
    return this.className;
  }

  public ConstructorInfo setClassName(java.lang.String className) {
    this.className = className;
    return this;
  }

  public void unsetClassName() {
    this.className = null;
  }

  /** Returns true if field className is set (has been assigned a value) and false otherwise */
  public boolean isSetClassName() {
    return this.className != null;
  }

  public void setClassNameIsSet(boolean value) {
    if (!value) {
      this.className = null;
    }
  }

  public int getParamListSize() {
    return (this.paramList == null) ? 0 : this.paramList.size();
  }

  public java.util.Iterator<ClassInfo> getParamListIterator() {
    return (this.paramList == null) ? null : this.paramList.iterator();
  }

  public void addToParamList(ClassInfo elem) {
    if (this.paramList == null) {
      this.paramList = new java.util.ArrayList<ClassInfo>();
    }
    this.paramList.add(elem);
  }

  public java.util.List<ClassInfo> getParamList() {
    return this.paramList;
  }

  public ConstructorInfo setParamList(java.util.List<ClassInfo> paramList) {
    this.paramList = paramList;
    return this;
  }

  public void unsetParamList() {
    this.paramList = null;
  }

  /** Returns true if field paramList is set (has been assigned a value) and false otherwise */
  public boolean isSetParamList() {
    return this.paramList != null;
  }

  public void setParamListIsSet(boolean value) {
    if (!value) {
      this.paramList = null;
    }
  }

  public int getModifiers() {
    return this.modifiers;
  }

  public ConstructorInfo setModifiers(int modifiers) {
    this.modifiers = modifiers;
    setModifiersIsSet(true);
    return this;
  }

  public void unsetModifiers() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __MODIFIERS_ISSET_ID);
  }

  /** Returns true if field modifiers is set (has been assigned a value) and false otherwise */
  public boolean isSetModifiers() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __MODIFIERS_ISSET_ID);
  }

  public void setModifiersIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __MODIFIERS_ISSET_ID, value);
  }

  public boolean isIsAccessible() {
    return this.isAccessible;
  }

  public ConstructorInfo setIsAccessible(boolean isAccessible) {
    this.isAccessible = isAccessible;
    setIsAccessibleIsSet(true);
    return this;
  }

  public void unsetIsAccessible() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ISACCESSIBLE_ISSET_ID);
  }

  /** Returns true if field isAccessible is set (has been assigned a value) and false otherwise */
  public boolean isSetIsAccessible() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ISACCESSIBLE_ISSET_ID);
  }

  public void setIsAccessibleIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ISACCESSIBLE_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case CLASS_NAME:
      if (value == null) {
        unsetClassName();
      } else {
        setClassName((java.lang.String)value);
      }
      break;

    case PARAM_LIST:
      if (value == null) {
        unsetParamList();
      } else {
        setParamList((java.util.List<ClassInfo>)value);
      }
      break;

    case MODIFIERS:
      if (value == null) {
        unsetModifiers();
      } else {
        setModifiers((java.lang.Integer)value);
      }
      break;

    case IS_ACCESSIBLE:
      if (value == null) {
        unsetIsAccessible();
      } else {
        setIsAccessible((java.lang.Boolean)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case CLASS_NAME:
      return getClassName();

    case PARAM_LIST:
      return getParamList();

    case MODIFIERS:
      return getModifiers();

    case IS_ACCESSIBLE:
      return isIsAccessible();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case CLASS_NAME:
      return isSetClassName();
    case PARAM_LIST:
      return isSetParamList();
    case MODIFIERS:
      return isSetModifiers();
    case IS_ACCESSIBLE:
      return isSetIsAccessible();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof ConstructorInfo)
      return this.equals((ConstructorInfo)that);
    return false;
  }

  public boolean equals(ConstructorInfo that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_className = true && this.isSetClassName();
    boolean that_present_className = true && that.isSetClassName();
    if (this_present_className || that_present_className) {
      if (!(this_present_className && that_present_className))
        return false;
      if (!this.className.equals(that.className))
        return false;
    }

    boolean this_present_paramList = true && this.isSetParamList();
    boolean that_present_paramList = true && that.isSetParamList();
    if (this_present_paramList || that_present_paramList) {
      if (!(this_present_paramList && that_present_paramList))
        return false;
      if (!this.paramList.equals(that.paramList))
        return false;
    }

    boolean this_present_modifiers = true;
    boolean that_present_modifiers = true;
    if (this_present_modifiers || that_present_modifiers) {
      if (!(this_present_modifiers && that_present_modifiers))
        return false;
      if (this.modifiers != that.modifiers)
        return false;
    }

    boolean this_present_isAccessible = true;
    boolean that_present_isAccessible = true;
    if (this_present_isAccessible || that_present_isAccessible) {
      if (!(this_present_isAccessible && that_present_isAccessible))
        return false;
      if (this.isAccessible != that.isAccessible)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetClassName()) ? 131071 : 524287);
    if (isSetClassName())
      hashCode = hashCode * 8191 + className.hashCode();

    hashCode = hashCode * 8191 + ((isSetParamList()) ? 131071 : 524287);
    if (isSetParamList())
      hashCode = hashCode * 8191 + paramList.hashCode();

    hashCode = hashCode * 8191 + modifiers;

    hashCode = hashCode * 8191 + ((isAccessible) ? 131071 : 524287);

    return hashCode;
  }

  @Override
  public int compareTo(ConstructorInfo other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetClassName()).compareTo(other.isSetClassName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClassName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.className, other.className);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetParamList()).compareTo(other.isSetParamList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParamList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.paramList, other.paramList);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetModifiers()).compareTo(other.isSetModifiers());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetModifiers()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.modifiers, other.modifiers);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetIsAccessible()).compareTo(other.isSetIsAccessible());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIsAccessible()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.isAccessible, other.isAccessible);
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
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ConstructorInfo(");
    boolean first = true;

    sb.append("className:");
    if (this.className == null) {
      sb.append("null");
    } else {
      sb.append(this.className);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("paramList:");
    if (this.paramList == null) {
      sb.append("null");
    } else {
      sb.append(this.paramList);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("modifiers:");
    sb.append(this.modifiers);
    first = false;
    if (!first) sb.append(", ");
    sb.append("isAccessible:");
    sb.append(this.isAccessible);
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

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ConstructorInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ConstructorInfoStandardScheme getScheme() {
      return new ConstructorInfoStandardScheme();
    }
  }

  private static class ConstructorInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<ConstructorInfo> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ConstructorInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // CLASS_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.className = iprot.readString();
              struct.setClassNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PARAM_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list32 = iprot.readListBegin();
                struct.paramList = new java.util.ArrayList<ClassInfo>(_list32.size);
                ClassInfo _elem33;
                for (int _i34 = 0; _i34 < _list32.size; ++_i34)
                {
                  _elem33 = new ClassInfo();
                  _elem33.read(iprot);
                  struct.paramList.add(_elem33);
                }
                iprot.readListEnd();
              }
              struct.setParamListIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MODIFIERS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.modifiers = iprot.readI32();
              struct.setModifiersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // IS_ACCESSIBLE
            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
              struct.isAccessible = iprot.readBool();
              struct.setIsAccessibleIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, ConstructorInfo struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.className != null) {
        oprot.writeFieldBegin(CLASS_NAME_FIELD_DESC);
        oprot.writeString(struct.className);
        oprot.writeFieldEnd();
      }
      if (struct.paramList != null) {
        oprot.writeFieldBegin(PARAM_LIST_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.paramList.size()));
          for (ClassInfo _iter35 : struct.paramList)
          {
            _iter35.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(MODIFIERS_FIELD_DESC);
      oprot.writeI32(struct.modifiers);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(IS_ACCESSIBLE_FIELD_DESC);
      oprot.writeBool(struct.isAccessible);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ConstructorInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ConstructorInfoTupleScheme getScheme() {
      return new ConstructorInfoTupleScheme();
    }
  }

  private static class ConstructorInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<ConstructorInfo> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ConstructorInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetClassName()) {
        optionals.set(0);
      }
      if (struct.isSetParamList()) {
        optionals.set(1);
      }
      if (struct.isSetModifiers()) {
        optionals.set(2);
      }
      if (struct.isSetIsAccessible()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetClassName()) {
        oprot.writeString(struct.className);
      }
      if (struct.isSetParamList()) {
        {
          oprot.writeI32(struct.paramList.size());
          for (ClassInfo _iter36 : struct.paramList)
          {
            _iter36.write(oprot);
          }
        }
      }
      if (struct.isSetModifiers()) {
        oprot.writeI32(struct.modifiers);
      }
      if (struct.isSetIsAccessible()) {
        oprot.writeBool(struct.isAccessible);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ConstructorInfo struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.className = iprot.readString();
        struct.setClassNameIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list37 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.paramList = new java.util.ArrayList<ClassInfo>(_list37.size);
          ClassInfo _elem38;
          for (int _i39 = 0; _i39 < _list37.size; ++_i39)
          {
            _elem38 = new ClassInfo();
            _elem38.read(iprot);
            struct.paramList.add(_elem38);
          }
        }
        struct.setParamListIsSet(true);
      }
      if (incoming.get(2)) {
        struct.modifiers = iprot.readI32();
        struct.setModifiersIsSet(true);
      }
      if (incoming.get(3)) {
        struct.isAccessible = iprot.readBool();
        struct.setIsAccessibleIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

