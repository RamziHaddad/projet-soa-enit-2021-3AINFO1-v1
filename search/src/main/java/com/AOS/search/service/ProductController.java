package com.AOS.search.service;

import com.AOS.search.service.lucene.file.LuceneReadIndexFromFileExample;
import org.apache.lucene.document.Document;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProductController {

  private static final String templateDesc = "Product description";
  private static final String templateCategory = "Product category";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/Product/GetProductByDesc")
  public String productByDesc(@RequestParam(value = "desc", defaultValue = "Product description ...") String desc ) throws Exception {

    //Create lucene searcher. It search over a single IndexReader.
    IndexSearcher searcher = LuceneReadIndexFromFileExample.createSearcher();

    //Search indexed description using search term
    TopDocs foundDocs = LuceneReadIndexFromFileExample.searchInDescription("agreeable", searcher);

    //Total found documents
    System.out.println("Total Results :: " + foundDocs.totalHits);

    //Let's print out the path of files which have searched term
    String resp="";
    for (ScoreDoc sd : foundDocs.scoreDocs)
    {
      Document d = searcher.doc(sd.doc);
      System.out.println("Path : "+ d.get("path") + ", Score : " + sd.score);
      resp+= d.get("name")+"\n";
    }
    return resp;
  }

  @GetMapping("/Product/GetProductByCategory")
  public String productByCategory(@RequestParam(value = "category", defaultValue = "Product category ...") String category ) throws Exception {
    //Create lucene searcher. It search over a single IndexReader.
    IndexSearcher searcher = LuceneReadIndexFromFileExample.createSearcher();


    //Search indexed category using search term
    TopDocs foundDocs = LuceneReadIndexFromFileExample.searchInCategory("chaise", searcher);

    //Total found documents
    System.out.println("Total Results :: " + foundDocs.totalHits);

    //Let's print out the path of files which have searched term
    String resp = "";
    for (ScoreDoc sd : foundDocs.scoreDocs) {
      Document d = searcher.doc(sd.doc);
      System.out.println("Path : " + d.get("path") + ", Score : " + sd.score);
      resp += d.get("name") + "\n";
    }
    return resp;
  }
}
