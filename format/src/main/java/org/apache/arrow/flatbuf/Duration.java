/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.arrow.flatbuf;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class Duration extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_25_2_10(); }
  public static Duration getRootAsDuration(ByteBuffer _bb) { return getRootAsDuration(_bb, new Duration()); }
  public static Duration getRootAsDuration(ByteBuffer _bb, Duration obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Duration __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public short unit() { int o = __offset(4); return o != 0 ? bb.getShort(o + bb_pos) : 1; }

  public static int createDuration(FlatBufferBuilder builder,
      short unit) {
    builder.startTable(1);
    Duration.addUnit(builder, unit);
    return Duration.endDuration(builder);
  }

  public static void startDuration(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addUnit(FlatBufferBuilder builder, short unit) { builder.addShort(0, unit, 1); }
  public static int endDuration(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Duration get(int j) { return get(new Duration(), j); }
    public Duration get(Duration obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}
