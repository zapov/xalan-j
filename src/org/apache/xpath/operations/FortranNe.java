/*
 * The Apache Software License, Version 1.1
 *
 *
 * Copyright (c) 1999 The Apache Software Foundation.  All rights 
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:  
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Xalan" and "Apache Software Foundation" must
 *    not be used to endorse or promote products derived from this
 *    software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    nor may "Apache" appear in their name, without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation and was
 * originally based on software copyright (c) 1999, Lotus
 * Development Corporation., http://www.lotus.com.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
package org.apache.xpath.operations;

import javax.xml.transform.TransformerException;

import org.apache.xml.dtm.XType;
import org.apache.xpath.XPathContext;
import org.apache.xpath.objects.XBoolean;
import org.apache.xpath.objects.XObject;

/**
 * The 'ne' operation expression executer.
 */
public class FortranNe extends OperationNormalized
{
  static GenericOpFunc IsNotEqualObj = new GenericOpFunc()
  {
    /**
     * @see org.apache.xpath.operations.opfuncs.GenericOpFunc#operate(XPathContext, XObject, XObject)
     */
    public XObject operate(XPathContext xctxt, XObject lhs, XObject rhs)
    {
      return lhs.equals(rhs) ? XBoolean.S_FALSE : XBoolean.S_TRUE;
    }

  };

  static OpFuncLookupTable m_funcs;
  {
    m_funcs = new OpFuncLookupTable();
    m_funcs.setFunc(XType.DOUBLE, new GenericOpFunc()
    {
      public XObject operate(XPathContext xctxt, XObject lhs, XObject rhs)
        throws TransformerException
      {
        return (lhs.num() != rhs.num()) ? XBoolean.S_TRUE : XBoolean.S_FALSE;
      }
    });
    m_funcs.setFunc(XType.FLOAT, new GenericOpFunc()
    {
      public XObject operate(XPathContext xctxt, XObject lhs, XObject rhs)
        throws TransformerException
      {
        return (lhs.num() != rhs.num()) ? XBoolean.S_TRUE : XBoolean.S_FALSE;
      }
    });
    m_funcs.setFunc(XType.INTEGER, new GenericOpFunc()
    {
      public XObject operate(XPathContext xctxt, XObject lhs, XObject rhs)
        throws TransformerException
      {
        return (lhs.num() != rhs.num()) ? XBoolean.S_TRUE : XBoolean.S_FALSE;
      }
    });
    m_funcs.setFunc(XType.DECIMAL, IsNotEqualObj);

    m_funcs.setFunc(XType.DURATION, IsNotEqualObj);
    m_funcs.setFunc(XType.DAYTIMEDURATION, IsNotEqualObj);
    m_funcs.setFunc(XType.YEARMONTHDURATION, IsNotEqualObj);
    
    m_funcs.setFunc(XType.DATETIME, IsNotEqualObj);
    m_funcs.setFunc(XType.TIME, IsNotEqualObj);
    m_funcs.setFunc(XType.DATE, IsNotEqualObj);
    m_funcs.setFunc(XType.GYEARMONTH, IsNotEqualObj);
    m_funcs.setFunc(XType.GYEAR, IsNotEqualObj);
    m_funcs.setFunc(XType.GMONTHDAY, IsNotEqualObj);
    m_funcs.setFunc(XType.GDAY, IsNotEqualObj);
    m_funcs.setFunc(XType.GMONTH, IsNotEqualObj);

    m_funcs.setFunc(XType.BOOLEAN, IsNotEqualObj);
    m_funcs.setFunc(XType.STRING, IsNotEqualObj);
    m_funcs.setFunc(XType.BASE64BINARY, IsNotEqualObj);
    m_funcs.setFunc(XType.HEXBINARY, IsNotEqualObj);
    m_funcs.setFunc(XType.ANYURI, IsNotEqualObj);
    m_funcs.setFunc(XType.QNAME, IsNotEqualObj);
    m_funcs.setFunc(XType.NOTATION, IsNotEqualObj);
  }
  
  /**
   * @see org.apache.xpath.operations.Operation#getLookupTable()
   */
  public OpFuncLookupTable getLookupTable()
  {
    return m_funcs;
  }
}