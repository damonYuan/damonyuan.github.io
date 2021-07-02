Large website technical architecture
====

第一篇 概述

# 演化
# 模式
# 構架要素

1. performance
2. robustness
3. scalability
4. extensibility
5. security

第二篇 構架

4 瞬時響應
  4.1 網站性能測試
  4.1.1 視角
      1. 用戶視角
      2. 開發人員視角
      3. 運維人員視角
  4.1.2 性能測試指標
      1. 響應時間
      2. 並發數
      3. 吞吐量
      4. 性能計數器
         在Linux 系統中使用top 命令查看 system load, load average: 是三個浮點數，表示最近1分鐘，10分鐘，15分鐘的運行隊列平均進程數。
  4.1.3 性能測試方法
      1. 性能測試
      2. 負載測試
      3. 壓力測試
      4. 穩定性測試
  4.1.4 性能測試報告
  4.1.5 性能優化策略
      1. 性能分析
         * 內存
         * 磁盤
         * 網絡
         * CPU
         * 代碼
         * 構架
         * 系統資源
       2. 性能優化

  4.2 Web前端性能優化
  4.2.1 瀏覽器訪問優化
      1. 減少http請求
      2. 使用瀏覽器緩存
         Cache-Control and Expires in Http headers
      3. 啟用壓縮： 但是對服務器和流浪器產生一定壓力
      4. CSS 放在頁面最上面，JavaScript 放在頁面最下面。 但是如果頁面解析時候就需要用到js就不應該這麼做。
      5. 減少Cookie傳輸；靜態資源使用獨立域名訪問。
      6. CDN加速
      7. 反向代理 - 配置緩存功能

  4.3 應用服務器性能優化
      1. 分佈式緩存
      2. 合理使用
         緩存預熱
         緩存穿透
      3. 分佈式
         * JBoss Cache
           多用於企業應用系統： 在集群中所有服務器中保存相同的緩存書記， 當某台服務器有緩存數據更新的時候，會通知集群中其他機器更新或清除緩存數據。
         * Memcached -> Libevent
           - slab_class -> slab -> chunk
             參數設計及其重要，否則會浪費內存
             集群內服務器互不通信可以做到幾乎無限制的線性伸縮
      4. 異步
         需要業務流程配合： 任何可以晚點做的事情都應該晚點再做。
      5. 使用集群
      6. 代碼優化
         * 多線程
           啟動線程數=「任務執行時間/（任務執行時間 - IO等待時間）」x CPU內核數
            - 計算型
            - IO 型

            1. 無狀態
            2. 局部對象
            3. 鎖

         * 資源複用
            1. Singleton
            2. Object Pool
               database connection pool
               thread pool
          * 數據結構
             eg: Hashcode
             String - MD5 -> finger print - Hash function -> Hash code

          * 垃圾回收 garbage collection
             JVM -> Stack : argument, local variable, etc
                    Heap : Object

                    Young Generation (sizE)
                      - Eden Space
                      - From 
                      - To
                    Old Generation (size)

                    Old GC
                    Young GC
                    Full GC

           * 存儲性能的優化
               * 機械硬盤 / SSD
               * B+ Tree /  LSM Tree
               > https://www.percona.com/blog/2016/01/06/mongodb-revs-you-up-what-storage-engine-is-right-part-1/
                  * database engines
                    - LSM tree (Log structured merge tree)
                      > https://www.igvita.com/2012/02/06/sstable-and-log-structured-storage-leveldb/

                      > https://www.igvita.com/2009/06/23/measuring-optimizing-io-performance/
                      * Monitoring IO Performance with iostat

               * RAID (redundant array of independent disks) vs HDFS (Hadoop Distributed File System) 

                    - B tree
                    - Fractal tree



  



