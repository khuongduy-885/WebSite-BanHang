/**
 * 
 */
package com.khuongduy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.khuongduy.business.DanhMucBusiness;
import com.khuongduy.business.SanPhamBusiness;
import com.khuongduy.entity.DanhMuc;
import com.khuongduy.entity.ObjCheck;
import com.khuongduy.entity.SanPham;

/**
 * @author Khuong Duy
 *
 */
@Controller
public class SanPhamController
{
	@Autowired
	SanPhamBusiness sanPhamBusiness;

	@Autowired
	DanhMucBusiness danhMucBusiness;

	@RequestMapping(value = "/themsanpham", method = RequestMethod.GET)
	public String themsanpham(Model model) throws Exception
	{
		try
		{
			List<SanPham> sanPhams = sanPhamBusiness.fileall();
			model.addAttribute("listSphanPhams", sanPhams);
			List<DanhMuc> danhMucs = danhMucBusiness.fileall();
			model.addAttribute("danhmuc", danhMucs);
		} catch (Exception e)
		{
			throw new Exception(e.getMessage());
		}
		return "themsanpham";
	}

	@RequestMapping(value = "/deletesanpham", method = RequestMethod.POST, produces = "plain/text; charset=UTF-8")
	@ResponseBody
	public ObjCheck xoasanphamtheoma(@RequestParam int masanpham) throws Exception
	{
		ObjCheck objCheck = new ObjCheck();
		try
		{
			objCheck = sanPhamBusiness.xoasanphamtheoma(masanpham);
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}

	@RequestMapping(value = "/updatesanpham", method = RequestMethod.POST, produces = "plain/text; charset=UTF-8")
	@ResponseBody
	public ObjCheck capnhatsanpham(@RequestParam String datajson) throws Exception
	{
		ObjCheck objCheck = new ObjCheck();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonobject;
		try
		{
			SanPham sanPham = new SanPham();
			jsonobject = mapper.readTree(datajson);
			sanPham.setMadanhmuc(jsonobject.get("danhmucsanpham").asInt());
			sanPham.setTensanpham(jsonobject.get("tensanpham").asText());
			sanPham.setGiatien(jsonobject.get("giatien").asText());
			sanPham.setTinhtrang(jsonobject.get("tinhtrang").asText());
			sanPham.setHinhanh(jsonobject.get("hinhanh").asText());
			sanPham.setCauhinhmay(jsonobject.get("cauhinhmay").asText());
			sanPham.setNgaynhap(jsonobject.get("ngaynhap").asText());
			sanPham.setMasanpham(jsonobject.get("masanpham").asInt());
			objCheck = sanPhamBusiness.capnhatsanpham(sanPham);
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}

	@RequestMapping(value = "/insertdanhmuc")
	@ResponseBody
	public ObjCheck insertdanhmuc(@RequestParam String datajson)
	{
		ObjCheck objCheck = new ObjCheck();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonobject;
		SanPham sanPham = new SanPham();
		try
		{
			jsonobject = mapper.readTree(datajson);
			sanPham.setMadanhmuc(jsonobject.get("danhmucsanpham").asInt());
			sanPham.setTensanpham(jsonobject.get("tensanpham").asText());
			sanPham.setGiatien(jsonobject.get("giatien").asText());
			sanPham.setTinhtrang(jsonobject.get("tinhtrang").asText());
			sanPham.setHinhanh(jsonobject.get("hinhanh").asText());
			sanPham.setCauhinhmay(jsonobject.get("cauhinhmay").asText());
			sanPham.setNgaynhap(jsonobject.get("ngaynhap").asText());

			objCheck = sanPhamBusiness.themsanpham(sanPham);
		} catch (Exception e)
		{
			objCheck.setStatus(0);
			objCheck.setSuccess(e.getMessage());
			return objCheck;
		}
		return objCheck;
	}

}