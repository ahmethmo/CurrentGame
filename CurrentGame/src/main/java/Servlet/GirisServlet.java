package Servlet;


import Ara.Entity.BanlıHero;
import Ara.Entity.CurrentGame;
import Ara.Entity.Sihirdarlar;
import Ara.Jsons.CurrentGameJson;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/giris")
public class GirisServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String KAdi=req.getParameter("smrName");
        String Bolge=req.getParameter("smrName2");
        //System.out.println(KAdi+"  "+Bolge);
        CurrentGameJson OyunBilgileri=new CurrentGameJson();
        CurrentGame CG= OyunBilgileri.GetCurrentgame(KAdi, Bolge);
        
        List<Sihirdarlar> Sh1 = new ArrayList<>();
        List<Sihirdarlar> Sh2 = new ArrayList<>();
        List<BanlıHero> Bn1 = new ArrayList<>();
        List<BanlıHero> Bn2 = new ArrayList<>();
        
        for (Sihirdarlar sh : CG.getShrdrlar()) {
            if (sh.getTakımNo()==100) {
                Sh1.add(sh);
            }else{
                Sh2.add(sh);
            }
        }
        
        for (BanlıHero bn :CG.getBnlhrlar()) {
            if (bn.getTakımNo()==100) {
                Bn1.add(bn);
            }else{
                Bn2.add(bn);
            }
        }
        
        req.setAttribute("Sonuç1",Sh1);
        req.setAttribute("Sonuç2",Sh2);
        req.setAttribute("Banlar1",Bn1);
        req.setAttribute("Banlar2",Bn2);
        req.getRequestDispatcher("oyun.jsp").forward(req, resp);
    }
}
