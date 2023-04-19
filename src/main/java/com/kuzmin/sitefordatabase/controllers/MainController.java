package com.kuzmin.sitefordatabase.controllers;

import com.kuzmin.sitefordatabase.model.Goods;
import com.kuzmin.sitefordatabase.model.OrderClient;
import com.kuzmin.sitefordatabase.model.OrderLine;
import com.kuzmin.sitefordatabase.reposetdao.ClientRepository;
import com.kuzmin.sitefordatabase.reposetdao.GoodsRepository;
import com.kuzmin.sitefordatabase.reposetdao.OrderLineRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

import static java.lang.Long.getLong;
import static java.lang.Long.parseLong;

@Controller
public class MainController {


    //Главная страница
    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OrderLineRepos orderLineRepos;

    @GetMapping("/")
    public String main_goods(Model model) {
        Iterable<Goods> all = goodsRepository.findAll();//выбираем все записи
        model.addAttribute("all", all);//Передаем результат в шаблон для отображения
        return "goods";
    }

    @GetMapping("/client_view")
    public String clientView(Model model) {
        Iterable<OrderClient> allClients = clientRepository.findAll();//выбираем все записи
        model.addAttribute("allClients", allClients);
        return "client_view";
    }

    //Страница клиента
    @GetMapping("/client")
    public String client(Model model) {
        model.addAttribute("title", "Заказчик");
        return "client";
    }

    @PostMapping("/client")
    public String client(@RequestParam String client, @RequestParam String dateOrder, @RequestParam String address, Model model) {
        OrderClient orderClient = new OrderClient();
        orderClient.setClient(client);
        orderClient.setDateOrder(dateOrder);
        orderClient.setAddress(address);
        clientRepository.save(orderClient);
        return "redirect:/client_view";
    }



    //Страница введения данных товара
    @GetMapping("/goods_add")
    public String goods_add(Model model) {
        model.addAttribute("title", "Ввод товара в базу");
        return "goods_add";
    }

    //Введение в базу данных товара и переход на главную страницу отображения таблицы товаров
    @PostMapping("/goods_add")
    public String goods_add_post(@RequestParam String nameGoods, @RequestParam String price, Model model) {
        Goods goodsAdd = new Goods();
        goodsAdd.setNameGoods(nameGoods);
        goodsAdd.setPrice(price);
        goodsRepository.save(goodsAdd);
        return "redirect:/";
    }

    //Страница введения номера товара
    @GetMapping("/goods_id")
    public String goodsEntreId(Model model) {
        model.addAttribute("title", "Страничка ввода номера товара для поиска");
        return "goods_id";
    }
    //Cтраничка для вывода найденого товара
    @PostMapping("/goods_id")
    public String goodsId(@RequestParam long id, Model model) {
        if(!goodsRepository.existsById(id)){//Если номер отсутствует возвращаемся на главную
            return "redirect:/";
        }
        Optional<Goods> obj=goodsRepository.findById(id);
        ArrayList<Goods>result=new ArrayList<>();
        obj.ifPresent(result::add);
        model.addAttribute("result", result);
        return "goods_choice";
    }
    //Cтраничка для редактирования товара
    @GetMapping("/goods/{id}")
    public String goodsEdit(@PathVariable(value="id") long id, Model model) {
        Optional<Goods> obj=goodsRepository.findById(id);
        ArrayList<Goods>result=new ArrayList<>();
        obj.ifPresent(result::add);
        model.addAttribute("result", result);
        return "goods_edit";
    }
    //Cтраничка для перезаписи отредактированного товара
    @PostMapping("/goods/{id}")
    public String goodsUp(@PathVariable(value="id") long id, @RequestParam String nameGoods, @RequestParam String price,  Model model) {
        Goods goodsSaveEdit=goodsRepository.findById(id).orElseThrow();
        goodsSaveEdit.setNameGoods(nameGoods);
        goodsSaveEdit.setPrice(price);
        goodsRepository.save(goodsSaveEdit);
        return "redirect:/";
    }
    //Cтраничка для удаления товара
    @PostMapping("/goods/{id}/remove")
    public String goodsRemove(@PathVariable(value="id") long id,  Model model) {
        Goods goodsSaveEdit=goodsRepository.findById(id).orElseThrow();
        goodsRepository.delete(goodsSaveEdit);
        return "redirect:/";
    }
    //Страница введения номера заказа
    @GetMapping("/client_id")
    public String clientEntreId(Model model) {
        model.addAttribute("title", "Страничка ввода номера заказа для поиска");
        return "client_id";
    }
    //Cтраничка для вывода найденого заказа
    @PostMapping("/client_id")
    public String clientId(@RequestParam long id, Model model) {
        if(!clientRepository.existsById(id)){//Если номер отсутствует возвращаемся на главную
            return "redirect:/client_view";
        }
        Optional<OrderClient> obj=clientRepository.findById(id);
        ArrayList<OrderClient>result=new ArrayList<>();
        obj.ifPresent(result::add);
        model.addAttribute("result", result);
        return "client_choice";
    }

    //Cтраничка для редактирования заказа
    @GetMapping("/client/{id}")
    public String clientEdit(@PathVariable(value="id") long id, Model model) {
        Optional<OrderClient> obj=clientRepository.findById(id);
        ArrayList<OrderClient>result=new ArrayList<>();
        obj.ifPresent(result::add);
        model.addAttribute("result", result);
        return "client_edit";
    }
    //Cтраничка для перезаписи отредактированного заказа
    @PostMapping("/client/{id}")
    public String clientUp(@PathVariable(value="id") long id, @RequestParam String client, @RequestParam String dateOrder, @RequestParam String address, Model model) {
        OrderClient clientSaveEdit=clientRepository.findById(id).orElseThrow();
        clientSaveEdit.setClient(client);
        clientSaveEdit.setDateOrder(dateOrder);
        clientSaveEdit.setAddress(address);
        clientRepository.save(clientSaveEdit);
        return "redirect:/client_view";
    }

    //Cтраничка для удаления заказа
    @PostMapping("/client/{id}/remove")
    public String clientRemove(@PathVariable(value="id") long id,  Model model) {
        OrderClient clientRemove=clientRepository.findById(id).orElseThrow();
        clientRepository.delete(clientRemove);
        return "redirect:/client_view";
    }
    @GetMapping("/order_line")
    public String orderView(Model model) {
        Iterable<OrderLine> allOrder = orderLineRepos.findAll();//выбираем все записи
        model.addAttribute("allOrder", allOrder);
        return "order_line";
    }
    @GetMapping("/order_line_add")
    public String order_line_add( Model model) {
        model.addAttribute("title", "Страничка добавления заказа в журнал");
        return "/order_line_add";
    }

    @PostMapping("/order_line_add")
    public String orderLineAdd(@RequestParam Long order_id, @RequestParam Long goods_id, @RequestParam Long count, Model model) {
        OrderLine orderLineAdd = new OrderLine();
        orderLineAdd.setOrder_id(order_id);
        orderLineAdd.setGoods_id(goods_id);
        orderLineAdd.setCount(count);
        orderLineRepos.save(orderLineAdd);
        return "redirect:/order_line";
    }
    @PostMapping("/order_line/{id}/remove")
    public String orderLineRemove(@PathVariable(value="id") long id,  Model model) {
        OrderLine orderLineRemove=orderLineRepos.findById(id).orElseThrow();
        orderLineRepos.delete(orderLineRemove);
        return "redirect:/order_line";
    }
    //Cтраничка для редактирования заказа
    @GetMapping("/order_line/{id}")
    public String orderLineEdit(@PathVariable(value="id") long id, Model model) {
        Optional<OrderLine> obj=orderLineRepos.findById(id);
        ArrayList<OrderLine>result=new ArrayList<>();
        obj.ifPresent(result::add);
        model.addAttribute("result", result);
        return "order_line_edit";
    }

    @PostMapping("/order_line/{id}")
    public String orderLineSaveEdit(@RequestParam Long order_id, @RequestParam Long goods_id, @RequestParam Long count, Model model) {
        OrderLine orderLineEdit = new OrderLine();
        orderLineEdit.setOrder_id(order_id);
        orderLineEdit.setGoods_id(goods_id);
        orderLineEdit.setCount(count);
        orderLineRepos.save(orderLineEdit);
        return "redirect:/order_line";
    }

}