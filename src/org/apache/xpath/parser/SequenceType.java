/* Generated By:JJTree: Do not edit this line. SequenceType.java */

package org.apache.xpath.parser;

import java.util.Vector;
import javax.xml.transform.TransformerException;

import org.apache.xml.utils.QName;
import org.apache.xpath.Expression;
import org.apache.xpath.ExpressionOwner;
import org.apache.xpath.XPathContext;
import org.apache.xpath.XPathVisitor;
import org.apache.xpath.objects.XObject;
import org.apache.xpath.types.InstanceofExpr;

public class SequenceType extends NonExecutableExpression
{
	
  /** The sequence on which to act. **/
  private Expression m_targetExpr;
  
  /** The node type value, one of DTMFilter.SHOW_ATTRIBUTE, etc. **/
  private int m_whatToShow;
  
  /** The atomic type ID, one of XType.BOOLEAN, etc. **/
  private int m_atomicTypeID;
  
  /** The occurance indicator ID.  One of ZERO_OR_MORE, etc. or EMPTY_SEQ **/
  private int m_occurrenceIndicator = InstanceofExpr.ONE_OR_MORE;
  
  /** The ElemOrAttrType name, meaning the tag QName, may be null. */
  private org.apache.xml.utils.QName m_elemOrAttrName;

  /** The SchemaType name, meaning the tag QName, may be null. */
  private org.apache.xml.utils.QName m_schemaTypeName;
  
  /** SchemaContext is not executable for the moment, so leave it 
   * as a NEE until we figure out what we want to do with it. **/
  private SchemaContext m_schemaContext;


  /**
   * Constructor for SequenceType.
   * @param parser
   * @param value
   */
  public SequenceType(XPath parser, String value)
  {
    super(parser, value);
  }

  /**
   * Constructor for SequenceType.
   * @param parser
   */
  public SequenceType(XPath parser)
  {
    super(parser);
  }

  /**
   * Returns the occurrenceIndicator.
   * @return int
   */
  public int getOccurrenceIndicator()
  {
    return m_occurrenceIndicator;
  }

  /**
   * Returns the schemaContext.
   * @return SchemaContext
   */
  public SchemaContext getSchemaContext()
  {
    return m_schemaContext;
  }

  /**
   * Returns the schemaTypeName.
   * @return org.apache.xml.utils.QName
   */
  public org.apache.xml.utils.QName getSchemaTypeName()
  {
    return m_schemaTypeName;
  }

  /**
   * Returns the targetExpr.
   * @return Expression
   */
  public Expression getTargetExpr()
  {
    return m_targetExpr;
  }

  /**
   * Returns the whatToShow.
   * @return int
   */
  public int getWhatToShow()
  {
    return m_whatToShow;
  }

  /**
   * Sets the occurrenceIndicator.
   * @param occurrenceIndicator The occurrenceIndicator to set
   */
  public void setOccurrenceIndicator(int occurrenceIndicator)
  {
    m_occurrenceIndicator = occurrenceIndicator;
  }

  /**
   * Sets the schemaContext.
   * @param schemaContext The schemaContext to set
   */
  public void setSchemaContext(SchemaContext schemaContext)
  {
    m_schemaContext = schemaContext;
  }

  /**
   * Sets the schemaTypeName.
   * @param schemaTypeName The schemaTypeName to set
   */
  public void setSchemaTypeName(org.apache.xml.utils.QName schemaTypeName)
  {
    m_schemaTypeName = schemaTypeName;
  }

  /**
   * Sets the targetExpr.
   * @param targetExpr The targetExpr to set
   */
  public void setTargetExpr(Expression targetExpr)
  {
    m_targetExpr = targetExpr;
  }

  /**
   * Sets the whatToShow.
   * @param whatToShow The whatToShow to set
   */
  public void setWhatToShow(int whatToShow)
  {
    m_whatToShow = whatToShow;
  }

  /**
   * Returns the atomicTypeID.
   * @return int
   */
  public int getAtomicTypeID()
  {
    return m_atomicTypeID;
  }

  /**
   * Returns the elemOrAttrName.
   * @return org.apache.xml.utils.QName
   */
  public org.apache.xml.utils.QName getElemOrAttrName()
  {
    return m_elemOrAttrName;
  }

  /**
   * Sets the atomicTypeID.
   * @param atomicTypeID The atomicTypeID to set
   */
  public void setAtomicTypeID(int atomicTypeID)
  {
    m_atomicTypeID = atomicTypeID;
  }

  /**
   * Sets the elemOrAttrName.
   * @param elemOrAttrName The elemOrAttrName to set
   */
  public void setElemOrAttrName(org.apache.xml.utils.QName elemOrAttrName)
  {
    m_elemOrAttrName = elemOrAttrName;
  }

	/**
	 * @see org.apache.xpath.parser.Node#jjtAddChild(Node, int)
	 */
	public void jjtAddChild(Node n, int i)
	{
		super.jjtAddChild(n, i);
		
		// It isn't. It's an OccurrenceIndicator, with m_occuranceType (oh,
		// you can't spell it consistantly either?) defaulting to unset (0);
		// its add-child or set-type methods aren't being invoked.
		// Another layer of dubious default; chase this farther up the grammar?
		
		if(n instanceof Empty)
			m_occurrenceIndicator=InstanceofExpr.EMPTY_SEQ;
	}

}
