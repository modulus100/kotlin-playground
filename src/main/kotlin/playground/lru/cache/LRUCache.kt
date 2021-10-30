package playground.lru.cache

interface Cache<K, V> {
    fun set(key: K, value: V)
    fun get(key: K): V?
}

data class Node<K, V>(
    val key: K,
    val value: V,
    var next: Node<K, V>? = null,
    var prev: Node<K, V>? = null
)

class LRUCache<K, V>(private val maxSize: Int) : Cache<K, V> {
    private val cache: MutableMap<K, Node<K, V>> = mutableMapOf()
    private var head: Node<K, V>? = null
    private var tail: Node<K, V>? = null

    init {
        if (maxSize < 1) {
            throw Exception("Min size is 1")
        }
    }

    override operator fun get(key: K): V? {
        val node = cache[key] ?: return null
        set(key, node.value)
        return node.value
    }

    override operator fun set(key: K, value: V) {
        if (cache.isEmpty() || maxSize == 1) {
            initHeadAndTail(key, value)
        } else if (cache.containsKey(key)) {
            moveKeyToHead(key, value)
        } else if (cache.size == maxSize) {
            addHeadRemoveTail(key, value)
        } else {
            addHead(key, value)
        }
    }

    private fun addHeadRemoveTail(key: K, value: V) {
        head = Node(key, value, head)
        cache.remove(tail?.key)
        tail = tail?.prev
        cache[key] = head!!
    }

    private fun initHeadAndTail(key: K, value: V) {
        cache.clear()
        cache[key] = Node(key, value)
        head = cache[key]
        tail = cache[key]
    }

    private fun addHead(key: K, value: V) {
        val newNode = Node(key, value, head)
        head = newNode
        newNode.next?.prev = newNode
        cache[key] = head!!
    }

    private fun moveKeyToHead(key: K, value: V) {
        val node = cache[key]
        node?.prev?.next = node?.next
        head = Node(key, value, head)
        head?.next?.prev = head
        cache[key] = head!!

        if (node == tail) {
            tail = node?.prev
        }
    }
}
