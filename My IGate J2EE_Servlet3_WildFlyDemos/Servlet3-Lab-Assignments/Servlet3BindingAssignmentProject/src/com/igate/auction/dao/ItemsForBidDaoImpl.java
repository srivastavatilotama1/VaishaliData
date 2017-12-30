package com.igate.auction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.igate.auction.dto.ItemsForBid;
import com.igate.auction.exception.BidException;
import com.igate.auction.exception.LoginException;
import com.igate.auction.util.DBUtil;

public class ItemsForBidDaoImpl  implements IItemsForBidDao
{

	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	Statement st=null;
	@Override
	public ArrayList<ItemsForBid> getAllBidItems() throws BidException
	{
		con=DBUtil.getConnection();
		String selectQry="select * from itemsforbid";
		ArrayList<ItemsForBid> itemBidList=new ArrayList<ItemsForBid>();
		try 
		{
			st=con.createStatement();
			rs=st.executeQuery(selectQry);
			while(rs.next())				
			{
				itemBidList.add(new ItemsForBid(rs.getInt(1),
						rs.getString(2),rs.getFloat(3),
						rs.getString(4)));
			}
			System.out.println(" Bid List  in Bid dao  is "+itemBidList);
		}
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		finally
		{
			try
			{
				con.close();
				st.close();
				rs.close();				
			}
			catch (SQLException e)
			{				
				e.printStackTrace();
				throw new BidException(e.getMessage());
			}
		}
		return itemBidList;
	}

	@Override
	public ItemsForBid getItemForBidById(int itemId) throws BidException 
	{	
		con=DBUtil.getConnection();
		String selectQry="select * from itemsforbid where itemid=? ";
		ItemsForBid itemBid=null;
		try 
		{
			pst=con.prepareStatement(selectQry);
			pst.setInt(1, itemId);
			rs=pst.executeQuery();
			while(rs.next())				
			{
				itemBid=new ItemsForBid(rs.getInt(1),
						rs.getString(2),rs.getFloat(3),
						rs.getString(4));
			}
			System.out.println(" My Bid Item in getItemForBidById() Is   "+itemBid);
		}
		catch (SQLException e) 
		{			
			e.printStackTrace();
		}
		finally
		{
			try
			{
				con.close();
				pst.close();
				rs.close();				
			}
			catch (SQLException e)
			{				
				e.printStackTrace();
				throw new BidException(e.getMessage());
			}
		}
		return itemBid;
	}

	@Override
	public int updateItemStatus(int itemId)
			throws BidException {
		con=DBUtil.getConnection();
		String updateQry="update itemsforbid set status=? where itemid=?";
		int updateCount=0;
		try 
		{
			pst=con.prepareStatement(updateQry);
			pst.setString(1, "Not Available");
			pst.setInt(2, itemId);
			updateCount=pst.executeUpdate();	
			//con.commit();
			System.out.println(" Updatee d item in dai    "+updateCount);
			
		}
		catch (SQLException e) 
		{		
			/*try 
			{
				//con.rollback();
			} 
			catch (SQLException e1) 
			{			
				throw new BidException(e.getMessage());
			}*/
			throw new BidException(e.getMessage());
		}
		finally
		{
			try
			{
				
				con.close();
				pst.close();						
			}
			catch (SQLException e)
			{				
				e.printStackTrace();
				throw new BidException(e.getMessage());
			}
		}
		return updateCount;
	}

	
}
