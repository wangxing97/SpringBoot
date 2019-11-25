package com.wx.springboot;
import com.wx.springboot.Repository.MyEsResPos;
import com.wx.springboot.Repository.MyEsResPos2;
import com.wx.springboot.bean.Book;
import com.wx.springboot.bean.Person;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    MyEsResPos myEsResPos;

    @Autowired
    MyEsResPos2 myEsResPos2;
    @Test
    public void testRes(){
        /*Iterable<Person> all = myEsResPos.findAll();
        for (Person person:all
             ) {
            System.out.println(person);
        }*/

        /*Person person = new Person();
        for(int i = 1;i<51;i++){
            person.setId(i);
            person.setLastName("王星"+i);
            Person person1 = myEsResPos.save(person);
        }*/
        //myEsResPos2.index(person);
       /* Optional<Person> byId = myEsResPos.findById(1);
        System.out.println(byId.toString());*/
    }
    //测试查询
    @Test
    public void testSearch(){
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.termQuery("id",1));
        Page<Person> page = myEsResPos2.search(builder.build());
        for ( Person person:page){
            System.out.println(person);
        }
    }

    //测试分页
    @Test
    public void testPage(){
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        int page = 1;
        int size = 5;
        builder.withPageable(PageRequest.of(page,size));
        Page<Person> items = myEsResPos2.search(builder.build());
        long total = items.getTotalElements();
        System.out.println("总条数 = " + total);
        System.out.println("总页数 = " + items.getTotalPages());
        System.out.println("当前页：" + items.getNumber());
        System.out.println("每页大小：" + items.getSize());
        for ( Person person:items){
            System.out.println(person);
        }
    }

    //测试排序
    @Test
    public void testSort(){
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withSort(SortBuilders.fieldSort("id").order(SortOrder.ASC));
        Page<Person> items = myEsResPos2.search(builder.build());
        for ( Person person:items){
            System.out.println(person);
        }
    }
    @Test
    public void contextloads() {
        Book book = new Book();
        book.setBookId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        Index index = new Index.Builder(book).index("es1").type("book").build();
        try {
            jestClient.execute(index);
        }catch (Exception e){
            System.out.println(e.getCause().toString());
        }
    }

    @Test
    public void search() {
        String json = "{\n" +
                "   \"query\": {\n" +
                "      \"match_all\": {}\n" +
                "   }\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("es1").addType("book").build();
        try {
            SearchResult execute = jestClient.execute(search);
            System.out.println(execute.getJsonString());
        }catch (Exception e){
            System.out.println(e.getCause().toString());
        }
    }

}
