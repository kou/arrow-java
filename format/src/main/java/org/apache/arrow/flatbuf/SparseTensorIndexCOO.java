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

/**
 * ----------------------------------------------------------------------
 * EXPERIMENTAL: Data structures for sparse tensors
 * Coordinate (COO) format of sparse tensor index.
 *
 * COO's index list are represented as a NxM matrix,
 * where N is the number of non-zero values,
 * and M is the number of dimensions of a sparse tensor.
 *
 * indicesBuffer stores the location and size of the data of this indices
 * matrix.  The value type and the stride of the indices matrix is
 * specified in indicesType and indicesStrides fields.
 *
 * For example, let X be a 2x3x4x5 tensor, and it has the following
 * 6 non-zero values:
 * ```text
 *   X[0, 1, 2, 0] := 1
 *   X[1, 1, 2, 3] := 2
 *   X[0, 2, 1, 0] := 3
 *   X[0, 1, 3, 0] := 4
 *   X[0, 1, 2, 1] := 5
 *   X[1, 2, 0, 4] := 6
 * ```
 * In COO format, the index matrix of X is the following 4x6 matrix:
 * ```text
 *   [[0, 0, 0, 0, 1, 1],
 *    [1, 1, 1, 2, 1, 2],
 *    [2, 2, 3, 1, 2, 0],
 *    [0, 1, 0, 0, 3, 4]]
 * ```
 * When isCanonical is true, the indices is sorted in lexicographical order
 * (row-major order), and it does not have duplicated entries.  Otherwise,
 * the indices may not be sorted, or may have duplicated entries.
 */
@SuppressWarnings("unused")
public final class SparseTensorIndexCOO extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_25_2_10(); }
  public static SparseTensorIndexCOO getRootAsSparseTensorIndexCOO(ByteBuffer _bb) { return getRootAsSparseTensorIndexCOO(_bb, new SparseTensorIndexCOO()); }
  public static SparseTensorIndexCOO getRootAsSparseTensorIndexCOO(ByteBuffer _bb, SparseTensorIndexCOO obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public SparseTensorIndexCOO __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  /**
   * The type of values in indicesBuffer
   */
  public org.apache.arrow.flatbuf.Int indicesType() { return indicesType(new org.apache.arrow.flatbuf.Int()); }
  public org.apache.arrow.flatbuf.Int indicesType(org.apache.arrow.flatbuf.Int obj) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  /**
   * Non-negative byte offsets to advance one value cell along each dimension
   * If omitted, default to row-major order (C-like).
   */
  public long indicesStrides(int j) { int o = __offset(6); return o != 0 ? bb.getLong(__vector(o) + j * 8) : 0; }
  public int indicesStridesLength() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }
  public LongVector indicesStridesVector() { return indicesStridesVector(new LongVector()); }
  public LongVector indicesStridesVector(LongVector obj) { int o = __offset(6); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer indicesStridesAsByteBuffer() { return __vector_as_bytebuffer(6, 8); }
  public ByteBuffer indicesStridesInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 8); }
  /**
   * The location and size of the indices matrix's data
   */
  public org.apache.arrow.flatbuf.Buffer indicesBuffer() { return indicesBuffer(new org.apache.arrow.flatbuf.Buffer()); }
  public org.apache.arrow.flatbuf.Buffer indicesBuffer(org.apache.arrow.flatbuf.Buffer obj) { int o = __offset(8); return o != 0 ? obj.__assign(o + bb_pos, bb) : null; }
  /**
   * This flag is true if and only if the indices matrix is sorted in
   * row-major order, and does not have duplicated entries.
   * This sort order is the same as of Tensorflow's SparseTensor,
   * but it is inverse order of SciPy's canonical coo_matrix
   * (SciPy employs column-major order for its coo_matrix).
   */
  public boolean isCanonical() { int o = __offset(10); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }

  public static void startSparseTensorIndexCOO(FlatBufferBuilder builder) { builder.startTable(4); }
  public static void addIndicesType(FlatBufferBuilder builder, int indicesTypeOffset) { builder.addOffset(0, indicesTypeOffset, 0); }
  public static void addIndicesStrides(FlatBufferBuilder builder, int indicesStridesOffset) { builder.addOffset(1, indicesStridesOffset, 0); }
  public static int createIndicesStridesVector(FlatBufferBuilder builder, long[] data) { builder.startVector(8, data.length, 8); for (int i = data.length - 1; i >= 0; i--) builder.addLong(data[i]); return builder.endVector(); }
  public static void startIndicesStridesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(8, numElems, 8); }
  public static void addIndicesBuffer(FlatBufferBuilder builder, int indicesBufferOffset) { builder.addStruct(2, indicesBufferOffset, 0); }
  public static void addIsCanonical(FlatBufferBuilder builder, boolean isCanonical) { builder.addBoolean(3, isCanonical, false); }
  public static int endSparseTensorIndexCOO(FlatBufferBuilder builder) {
    int o = builder.endTable();
    builder.required(o, 4);  // indicesType
    builder.required(o, 8);  // indicesBuffer
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public SparseTensorIndexCOO get(int j) { return get(new SparseTensorIndexCOO(), j); }
    public SparseTensorIndexCOO get(SparseTensorIndexCOO obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}
